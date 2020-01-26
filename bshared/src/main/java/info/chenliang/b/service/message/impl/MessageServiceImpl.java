package info.chenliang.b.service.message.impl;

import info.chenliang.b.MessageListener;
import info.chenliang.b.PublicationWriter;
import info.chenliang.b.SubscriptionReader;
import info.chenliang.b.generated.message.MessageWrapper;
import info.chenliang.b.service.message.Address;
import info.chenliang.b.service.message.MessageService;
import io.aeron.Aeron;
import io.aeron.Publication;
import io.aeron.Subscription;
import io.aeron.driver.MediaDriver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {
    @Autowired
    MediaDriver driver;

    private Map<String, Publication> publicationMap = new HashMap<>();
    private Map<String, SubscriptionReader> subscriptionReaderMap = new HashMap<>();

    ScheduledExecutorService service;

    @PostConstruct
    public void init() {
        service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(this::readSubscriptions, 0, 15, TimeUnit.MILLISECONDS);
    }

    private void readSubscriptions() {
        for (SubscriptionReader reader : subscriptionReaderMap.values()) {
            try {
                reader.tryReadMessage();
            } catch (Exception e) {
                log.error("Pulling message failure", e);
            }
        }
    }

    @Override
    public void send(Address address, MessageWrapper messageWrapper) {
        Publication publication = getPublication(address);

        PublicationWriter publicationWriter = PublicationWriter.builder().publication(publication).build();
        publicationWriter.publish(messageWrapper);
    }

    @Override
    public void receive(Address address, MessageListener listener) {
        String id = id(address);
        SubscriptionReader subscriptionReader = subscriptionReaderMap.get(id);
        if (subscriptionReader == null) {
            subscriptionReader = createSubscriptionReader(address, listener);
            subscriptionReaderMap.put(id(address), subscriptionReader);
        }
    }

    private SubscriptionReader createSubscriptionReader(Address address, MessageListener listener) {
        Subscription subscription = createSubscription(address);
        SubscriptionReader subscriptionReader = SubscriptionReader.builder().subscription(subscription).messageListener(listener).build();
        return subscriptionReader;
    }

    private Subscription createSubscription(Address address) {

        Aeron aeron = Aeron.connect(new Aeron.Context().aeronDirectoryName(driver.aeronDirectoryName()));
        return aeron.addSubscription(address.getChannel(), address.getStreamId());
    }

    private String id(Address address) {
        return String.format("%s:%s", address.getChannel(), address.getStreamId());
    }

    private Publication getPublication(Address address) {
        String id = id(address);
        Publication publication = publicationMap.get(id);
        if (publication == null) {
            Aeron aeron = Aeron.connect(new Aeron.Context().aeronDirectoryName(driver.aeronDirectoryName()));
            publication = aeron.addPublication(address.getChannel(), address.getStreamId());
            publicationMap.put(id, publication);
        }

        return publication;
    }
}

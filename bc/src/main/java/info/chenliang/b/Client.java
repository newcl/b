package info.chenliang.b;

import info.chenliang.b.message.Join;
import info.chenliang.b.message.MessageWrapper;
import io.aeron.Aeron;
import io.aeron.Publication;
import io.aeron.Subscription;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@Builder
public class Client {
    private final int subscriptionPort;
    private final int subscriptionStreamId;
    private final int publicationPort;
    private final int publicationStreamId;

    public void start(Aeron aeron) throws IOException {
        final String subChannel = String.format("aeron:udp?endpoint=0.0.0.0:%d", subscriptionPort);
        final String pubChannel = String.format("aeron:udp?endpoint=0.0.0.0:%d", publicationPort);

        Subscription subscription = aeron.addSubscription(subChannel, subscriptionStreamId);
        SubscriptionReader reader = SubscriptionReader.builder()
            .subscription(subscription)
            .messageListener(this::onMessage)
            .build();

        Publication publication = aeron.addPublication(pubChannel, publicationStreamId);
        PublicationWriter writer = PublicationWriter.builder().publication(publication).build();
        join(writer);

        while (true) {
            reader.tryReadMessage();
            Thread.yield();
        }
    }

    private void onMessage(MessageWrapper wrapper) {

    }

    private void join(PublicationWriter writer) throws IOException {
        MessageWrapper wrapper = MessageWrapper.newBuilder()
            .setJoin(Join.newBuilder()
                .setSubPort(subscriptionPort)
                .setSubStreamId(subscriptionStreamId)
                .setIp("0.0.0.0")
                .build())
            .build();
        writer.publish(wrapper);
    }
}

package info.chenliang.b.message.impl;

import info.chenliang.b.MessageListener;
import info.chenliang.b.PublicationWriter;
import info.chenliang.b.message.Address;
import info.chenliang.b.message.MessageService;
import info.chenliang.b.message.MessageWrapper;

import io.aeron.Aeron;
import io.aeron.Publication;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class MessageServiceImpl implements MessageService {
    @Autowired
    Aeron aeron;

    private Map<String, Publication> publicationMap = new HashMap<>();

    public void init() {

    }

    @Override
    public void send(Address address, MessageWrapper messageWrapper) {
        Publication publication = getPublication(address);

        PublicationWriter publicationWriter = PublicationWriter.builder().publication(publication).build();
        publicationWriter.publish(messageWrapper);
    }

    @Override
    public void receive(Address address, MessageListener listener) {

    }

    private String id(Address address) {
        return String.format("%s:%s:%s", address.getIp(), address.getPort(), address.getStreamId());
    }

    private Publication getPublication(Address address) {
        Publication publication = publicationMap.get(id(address));
        if (publication == null) {
            String channel = String.format("aeron:udp?endpoint=%s:%s", address.getIp(), address.getPort());
            aeron.addPublication(channel, address.getStreamId());
        }

        return publication;
    }
}

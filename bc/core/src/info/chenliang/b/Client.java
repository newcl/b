package info.chenliang.b;


import info.chenliang.b.generated.message.Handshake;
import info.chenliang.b.generated.message.MessageWrapper;
import info.chenliang.b.generated.message.Pong;
import info.chenliang.b.service.message.Address;
import info.chenliang.b.service.message.MessageService;
import info.chenliang.b.service.message.impl.AeronAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class Client {
    @Value("${client.subPort:9900}")
    private int subscriptionPort;

    @Value("${client.subStreamId:1}")
    private int subscriptionStreamId;

    @Value("${client.subIp:0.0.0.0}")
    private String subscriptionIp;

    @Value("${client.pubPort:40124}")
    private int publicationPort;

    @Value("${client.pubStreamId:1}")
    private int publicationStreamId;

    @Value("${client.pubIp:0.0.0.0}")
    private String publicationIp;

    @Value("${client.id:}")
    private String id;

    @Autowired
    MessageService messageService;

    @Autowired
    StatesManager statesManager;

    private Address subAddress, pubAddress;


    public Client() {

    }

    @PostConstruct
    public void start() {
        subAddress = AeronAddress.builder().ip(subscriptionIp).port(subscriptionPort).streamId(subscriptionStreamId).build();
        pubAddress = AeronAddress.builder().ip(publicationIp).port(publicationPort).streamId(publicationStreamId).build();

        messageService.receive(subAddress, this::onMessage);

        messageService.send(pubAddress, MessageWrapper.newBuilder()
            .setHandshake(Handshake.newBuilder()
                .setSubPort(subscriptionPort)
                .setSubStreamId(subscriptionStreamId)
                .setId(id)
                .build())
            .build());
    }

    private void onMessage(String identity, MessageWrapper wrapper) {
//        log.info("Received message from server {}", wrapper);
        if (wrapper.hasPing()) {
            Pong pong = Pong.newBuilder().setTime(System.currentTimeMillis()).setMessage("Pong from client").build();
            messageService.send(pubAddress, MessageWrapper.newBuilder().setPong(pong).build());
        } else if(wrapper.hasStates()) {
            statesManager.onStates(wrapper.getStates());
        }
    }
}

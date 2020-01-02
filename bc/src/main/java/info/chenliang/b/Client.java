package info.chenliang.b;

import info.chenliang.b.generated.message.Join;
import info.chenliang.b.generated.message.MessageWrapper;
import info.chenliang.b.generated.message.Pong;
import info.chenliang.b.generated.message.PongOrBuilder;
import info.chenliang.b.service.message.Address;
import info.chenliang.b.service.message.MessageService;
import info.chenliang.b.service.message.impl.AeronAddress;
import io.aeron.Aeron;
import io.aeron.Publication;
import io.aeron.Subscription;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class Client {
    @Value("${client.subPort:9900}")
    private int subscriptionPort;

    @Value("${client.subStreamId:1}")
    private int subscriptionStreamId;

    @Value("${client.pubPort:40124}")
    private int publicationPort;

    @Value("${client.pubStreamId:1}")
    private int publicationStreamId;

    @Autowired
    MessageService messageService;

    public void start() {
        messageService.receive(AeronAddress.builder().ip("0.0.0.0").port(subscriptionPort).streamId(subscriptionStreamId).build(), this::onMessage);

        messageService.send(AeronAddress.builder().ip("0.0.0.0").port(publicationPort).streamId(publicationStreamId).build(), MessageWrapper.newBuilder()
            .setJoin(Join.newBuilder()
                .setSubPort(subscriptionPort)
                .setSubStreamId(subscriptionStreamId)
                .setIp("0.0.0.0")
                .build())
            .build());
    }

    private void onMessage(Address from, MessageWrapper wrapper) {
        log.info("Received message from server {}", wrapper);
        if (wrapper.hasPing()) {
            Pong pong = Pong.newBuilder().setTime(System.currentTimeMillis()).setMessage("Pong from client").build();
            messageService.send(from, MessageWrapper.newBuilder().setPong(pong).build());
        }
    }
}

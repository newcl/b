package info.chenliang.b;


import akka.actor.typed.ActorSystem;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import info.chenliang.b.generated.message.Handshake;
import info.chenliang.b.generated.message.MessageWrapper;
import info.chenliang.b.generated.message.Pong;
import info.chenliang.b.service.message.ActorMessage;
import info.chenliang.b.service.message.Address;
import info.chenliang.b.service.message.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class Client extends AbstractBehavior<ActorMessage> {
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

    @Autowired
    MessageService messageService;

    private Address subAddress, pubAddress;

    public Client(ActorContext<ActorMessage> context) {
        super(context);

        context.
    }


    public void start() {
//        subAddress = AeronAddress.builder().ip(subscriptionIp).port(subscriptionPort).streamId(subscriptionStreamId).build();
//        pubAddress = AeronAddress.builder().ip(publicationIp).port(publicationPort).streamId(publicationStreamId).build();
//
//        messageService.receive(subAddress, this::onMessage);
//
//        messageService.send(pubAddress, MessageWrapper.newBuilder()
//            .setHandshake(Handshake.newBuilder()
//                .setSubPort(subscriptionPort)
//                .setSubStreamId(subscriptionStreamId)
//                .setIp("0.0.0.0")
//                .build())
//            .build());





//        ActorSelection selection =
//            context.actorSelection("akka://actorSystemName@10.0.0.1:25520/user/actorName");

    }

    public static Behavior<ActorMessage> create() {
        return Behaviors.setup(Client::new);
    }



    public Receive<ActorMessage> createReceive() {
        return newReceiveBuilder()
            .onMessage(ActorMessage.class, this::onMessage)
            .build();
    }

    private Behavior<ActorMessage> onMessage(ActorMessage actorMessage) {
        MessageWrapper wrapper = actorMessage.getMessageWrapper();
        log.info("Received message from server {}", wrapper);
        if (wrapper.hasPing()) {
            Pong pong = Pong.newBuilder().setTime(System.currentTimeMillis()).setMessage("Pong from client").build();
//            messageService.send(pubAddress, MessageWrapper.newBuilder().setPong(pong).build());
            MessageWrapper messageWrapper = MessageWrapper.newBuilder()
            .setHandshake(Handshake.newBuilder()
                .setSubPort(subscriptionPort)
                .setSubStreamId(subscriptionStreamId)
                .setIp("0.0.0.0")
                .build()).build();


            actorMessage.getActorRef().tell(ActorMessage.builder().actorRef(getContext().getSelf()).messageWrapper(messageWrapper).build());
        }
        return Behaviors.same();
    }

    private void onMessage2(String identity, MessageWrapper wrapper) {
        log.info("Received message from server {}", wrapper);
        if (wrapper.hasPing()) {
            Pong pong = Pong.newBuilder().setTime(System.currentTimeMillis()).setMessage("Pong from client").build();
            messageService.send(pubAddress, MessageWrapper.newBuilder().setPong(pong).build());
        }
    }
}

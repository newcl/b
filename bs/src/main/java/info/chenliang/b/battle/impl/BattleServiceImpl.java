package info.chenliang.b.battle.impl;

import akka.actor.ActorSystem;
import info.chenliang.b.battle.Battle;
import info.chenliang.b.battle.BattleService;
import info.chenliang.b.battle.PlayerService;
import info.chenliang.b.generated.message.Handshake;
import info.chenliang.b.generated.message.MessageWrapper;
import info.chenliang.b.generated.message.Ping;
import info.chenliang.b.service.message.Address;
import info.chenliang.b.service.message.MessageService;
import info.chenliang.b.service.message.impl.AeronAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class BattleServiceImpl implements BattleService {

    private ActorSystem actorSystem;

    @Autowired
    PlayerService playerService;

    @Autowired
    MessageService messageService;

    public BattleServiceImpl() {
      log.warn("BattleServiceImpl constructing");
    }

    @Override
    public Battle create() {
        BattleImpl battle = new BattleImpl();
        return battle;
    }

    @Override
    public void join(String battleId) {

    }

    private void initActorSystem() {
        actorSystem = ActorSystem.create("battleService");
    }

    @PostConstruct
    public void init() throws Exception {
        log.info("BattleServiceImpl initing");

        messageService.receive(AeronAddress.builder()
                .ip("0.0.0.0")
                .port(40125)
                .streamId(1).build(),
            this::onMessage);

        log.info("BattleServiceImpl init done");
    }

    void onMessage(String identity, MessageWrapper wrapper) {

        log.info("Client message {}", wrapper);
        if (wrapper.hasHandshake()) {
            log.info("Handshake received {}", wrapper.getHandshake());
            Handshake handshake = wrapper.getHandshake();

            Address subAddress = AeronAddress.builder()
                .ip(handshake.getIp())
                .port(handshake.getSubPort())
                .streamId(handshake.getSubStreamId()).build();
            playerService.getPlayer(identity).setSubscriptionAddress(subAddress);

            messageService.send(subAddress,
                MessageWrapper.newBuilder()
                    .setPing(Ping.newBuilder().setTime(System.currentTimeMillis()).setMessage("Ping!").build())
                    .build());
        } else if (wrapper.hasPong()) {
            log.info("Received pong from client {}", wrapper.getPong());

            Address subAddress = playerService.getPlayer(identity).getSubscriptionAddress();

            messageService.send(subAddress, MessageWrapper.newBuilder()
                .setPing(Ping.newBuilder().setTime(System.currentTimeMillis()).setMessage("Ping!").build())
                .build());
        }
    }

}

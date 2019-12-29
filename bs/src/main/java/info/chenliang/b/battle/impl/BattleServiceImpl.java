package info.chenliang.b.battle.impl;

import akka.actor.ActorSystem;
import info.chenliang.b.battle.Battle;
import info.chenliang.b.battle.BattleService;
import info.chenliang.b.battle.PlayerService;
import info.chenliang.b.message.Join;
import info.chenliang.b.message.MessageService;
import info.chenliang.b.message.MessageWrapper;
import info.chenliang.b.message.Ping;
import io.aeron.Aeron;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class BattleServiceImpl implements BattleService {

    private ActorSystem actorSystem;

    @Autowired
    Aeron aeron;

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

    public void init() throws Exception {
        log.info("BattleServiceImpl initing");

        messageService.receive(AeronAddress.builder()
                .ip("0.0.0.0")
                .port(40124)
                .streamId(1).build(),
            this::onMessage);

        log.info("BattleServiceImpl init done");
    }

    void onMessage(MessageWrapper wrapper) {

        if (wrapper.hasJoin()) {
            log.info("Join received {}", wrapper.getJoin());
            Join join = wrapper.getJoin();

            messageService.send(AeronAddress.builder()
                .ip(join.getIp())
                .port(join.getSubPort())
                .streamId(join.getSubStreamId()).build(),
                MessageWrapper.newBuilder()
                    .setPing(Ping.newBuilder().setTime(System.currentTimeMillis()).setMessage("Ping!").build())
                    .build());
        }
    }

}

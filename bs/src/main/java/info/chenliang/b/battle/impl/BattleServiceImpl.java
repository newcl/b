package info.chenliang.b.battle.impl;

import akka.actor.ActorSystem;
import info.chenliang.b.SubscriptionReader;
import info.chenliang.b.battle.Battle;
import info.chenliang.b.battle.BattleService;
import info.chenliang.b.battle.Player;
import info.chenliang.b.battle.PlayerService;
import info.chenliang.b.message.Join;
import info.chenliang.b.message.MessageWrapper;
import io.aeron.Aeron;
import io.aeron.Publication;
import io.aeron.Subscription;
import io.aeron.driver.MediaDriver;
import lombok.extern.slf4j.Slf4j;
import org.agrona.concurrent.UnsafeBuffer;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class BattleServiceImpl implements BattleService {

    private ActorSystem actorSystem;

    Aeron aeron;

    @Autowired
    PlayerService playerService;

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
        actorSystem = ActorSystem.create("batterService");
    }

    public void init() throws Exception {
        log.warn("BattleServiceImpl initing");

//        MediaDriver.Context context = new MediaDriver.Context();
//        context.aeronDirectoryName("/tmp");

//        final MediaDriver driver = MediaDriver.launchEmbedded(context);
        final MediaDriver driver = MediaDriver.launchEmbedded();
        log.warn(driver.aeronDirectoryName());

        aeron = Aeron.connect(new Aeron.Context().aeronDirectoryName(driver.aeronDirectoryName()));

        final String pubChannel = "aeron:udp?endpoint=0.0.0.0:40123";
        final int pubStreamId = 1;

        final String subChannel = "aeron:udp?endpoint=0.0.0.0:40124";
        final int subStreamId = 1;
        final Publication publication = aeron.addPublication(pubChannel, pubStreamId);
        final Subscription subscription = aeron.addSubscription(subChannel, subStreamId);

        SubscriptionReader subscriptionReader = SubscriptionReader.builder()
            .subscription(subscription)
            .messageListener(this::onMessage)
            .build();

        log.warn("BattleServiceImpl init done");

        while (true) {
            subscriptionReader.tryReadMessage();
            publication.offer(new UnsafeBuffer());
            Thread.sleep(100);
        }
    }

    void onMessage(MessageWrapper wrapper) {

        if (wrapper.hasJoin()) {
            Join join = wrapper.getJoin();
            int subPort = join.getSubPort();
            int subStreamId =join.getSubStreamId();

            Player player = playerService.getPlayer(String.format("%s:%d:%d", join.getIp(), subPort, subStreamId));
            
            aeron.addPublication(String.format("aeron:udp?endpoint=%s:%d", join.getIp(), subPort), subStreamId);
        }
    }

}

package info.chenliang.b.battle.impl;

import akka.actor.AbstractActorWithTimers;
import info.chenliang.b.battle.Battle;
import info.chenliang.b.message.MessageWrapper;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
public class BattleImpl extends AbstractActorWithTimers implements Battle {
    private static Object TICK_KEY = "TickKey";

    @Override
    public void onMessage(MessageWrapper wrapper) {

    }

    private static final class FirstTick {}

    private static final class Tick {}

    private long lastTick;

    @Override
    public Receive createReceive() {
        return receiveBuilder()
            .match(FirstTick.class, firstTick -> {
                init();
            })
            .match(Tick.class, tick -> {
                tick();
            })
            .build();
    }

    private void init() {
        getTimers().startPeriodicTimer(TICK_KEY, new Tick(), Duration.ofMillis(30));
        lastTick = System.currentTimeMillis();
    }

    private void tick() {
        long current = System.currentTimeMillis();
        long timeElapsed = current - lastTick;
        log.warn("Time elapsed {} millis", timeElapsed);
        lastTick = current;
    }
}

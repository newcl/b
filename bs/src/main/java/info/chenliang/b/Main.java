package info.chenliang.b;

import info.chenliang.b.battle.BattleService;
import info.chenliang.b.battle.PlayerService;
import info.chenliang.b.battle.impl.BattleServiceImpl;
import info.chenliang.b.battle.impl.PlayerServiceImpl;
import info.chenliang.b.service.message.MessageService;
import info.chenliang.b.service.message.impl.MessageServiceImpl;
import io.aeron.Aeron;
import io.aeron.driver.MediaDriver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean(initMethod = "init")
    public BattleService battleService() {
        return new BattleServiceImpl();
    }

    @Bean(initMethod = "init")
    public PlayerService playerService() {
        return new PlayerServiceImpl();
    }

    @Bean(initMethod = "init")
    public MessageService messageService() {
        return new MessageServiceImpl();
    }

    @Bean
    public MediaDriver mediaDriver() {
        return MediaDriver.launchEmbedded();
    }
}

package info.chenliang.b;

import info.chenliang.b.battle.BattleService;
import info.chenliang.b.battle.PlayerService;
import info.chenliang.b.battle.impl.BattleServiceImpl;
import info.chenliang.b.battle.impl.PlayerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
}

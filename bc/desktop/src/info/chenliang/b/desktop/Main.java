package info.chenliang.b.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import info.chenliang.b.MyGdxGame;
import io.aeron.driver.MediaDriver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication(scanBasePackages = "info.chenliang.b")
public class Main {
    @Bean
    public MediaDriver mediaDriver() {
        return MediaDriver.launchEmbedded();
    }

    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1024;
        config.height = 768;
        config.resizable = false;
        new LwjglApplication(new MyGdxGame(), config);
        SpringApplication.run(Main.class, args);
    }
}

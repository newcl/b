package info.chenliang.b;

import io.aeron.driver.MediaDriver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication(scanBasePackages = {"info.chenliang.b", "info.chenliang.b.desktop"})
public class Main {
    @Bean
    public MediaDriver mediaDriver() {
        return MediaDriver.launchEmbedded();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

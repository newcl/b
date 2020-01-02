package info.chenliang.b;

import info.chenliang.b.service.message.MessageService;
import info.chenliang.b.service.message.impl.MessageServiceImpl;
import io.aeron.Aeron;
import io.aeron.driver.MediaDriver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class Main {

    @Bean(initMethod = "init")
    public MessageService messageService() {
        return new MessageServiceImpl();
    }

    @Bean
    public MediaDriver mediaDriver() {
        return MediaDriver.launchEmbedded();
    }

    @Bean(initMethod = "start")
    public Client client() {
        return new Client();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

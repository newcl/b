package info.chenliang.b;

import io.aeron.Aeron;
import io.aeron.driver.MediaDriver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) throws Exception {
        int subPort = Integer.parseInt(args[0]);
        int subStreamId = Integer.parseInt(args[1]);

        int pubPort = Integer.parseInt(args[2]);
        int pubStreamId = Integer.parseInt(args[3]);

        final MediaDriver driver = MediaDriver.launchEmbedded();
        Aeron aeron = Aeron.connect(new Aeron.Context().aeronDirectoryName(driver.aeronDirectoryName()));

        Client client = Client.builder()
            .subscriptionPort(subPort)
            .subscriptionStreamId(subStreamId)
            .publicationPort(pubPort)
            .publicationStreamId(pubStreamId)
            .build();

        client.start(aeron);
    }


}

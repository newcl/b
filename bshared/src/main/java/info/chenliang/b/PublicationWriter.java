package info.chenliang.b;


import info.chenliang.b.generated.message.MessageWrapper;
import io.aeron.Publication;
import lombok.Builder;
import org.agrona.concurrent.UnsafeBuffer;

import static io.aeron.Publication.ADMIN_ACTION;
import static io.aeron.Publication.BACK_PRESSURED;
import static io.aeron.Publication.NOT_CONNECTED;

@Builder
public class PublicationWriter {
    private final Publication publication;

    public void publish(MessageWrapper wrapper) {
        UnsafeBuffer buffer = new UnsafeBuffer(wrapper.toByteArray());
        long result = publication.offer(buffer);

        while (result == ADMIN_ACTION || result == BACK_PRESSURED || result == NOT_CONNECTED) {
            result = publication.offer(buffer);
        }

        if (result < 0) throw new RuntimeException("Unable to publish message " + result);
    }
}

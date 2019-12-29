package info.chenliang.b;


import info.chenliang.b.message.MessageWrapper;
import io.aeron.Publication;
import lombok.Builder;
import org.agrona.concurrent.UnsafeBuffer;

import static io.aeron.Publication.*;

@Builder
public class PublicationWriter {
    private final Publication publication;

    public void publish(MessageWrapper wrapper) {
        UnsafeBuffer buffer = new UnsafeBuffer(wrapper.toByteArray());
        long result = publication.offer(buffer);

        while (result == ADMIN_ACTION || result == BACK_PRESSURED || result == NOT_CONNECTED) {
            result = publication.offer(buffer);
        }

        if (result < 0) throw new RuntimeException("Unable to join");
    }
}

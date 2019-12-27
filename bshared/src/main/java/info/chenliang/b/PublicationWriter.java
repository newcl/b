package info.chenliang.b;


import info.chenliang.b.message.MessageWrapper;
import io.aeron.Publication;
import lombok.Builder;
import org.agrona.concurrent.UnsafeBuffer;

import static io.aeron.Publication.ADMIN_ACTION;
import static io.aeron.Publication.BACK_PRESSURED;

@Builder
public class PublicationWriter {
    private final Publication publication;

    UnsafeBuffer buffer = new UnsafeBuffer(new byte[64*1024]);

    public void publish(MessageWrapper wrapper) {
        buffer.putBytes(0, wrapper.toByteArray());
        long result = publication.offer(buffer);

        while (result == ADMIN_ACTION || result == BACK_PRESSURED) {
            result = publication.offer(buffer);
        }

        if (result < 0) throw new RuntimeException("Unable to join");
    }
}

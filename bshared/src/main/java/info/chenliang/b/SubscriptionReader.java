package info.chenliang.b;

import info.chenliang.b.generated.message.MessageWrapper;
import io.aeron.FragmentAssembler;
import io.aeron.Image;
import io.aeron.Subscription;
import io.aeron.logbuffer.FragmentHandler;
import io.aeron.logbuffer.Header;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.agrona.DirectBuffer;

@Slf4j
public class SubscriptionReader {
    private final Subscription subscription;
    private final MessageListener messageListener;

    private final FragmentHandler fragmentAssembler;

    private SubscriptionReader(Subscription subscription, MessageListener messageListener) {
        this.subscription = subscription;
        this.messageListener = messageListener;
        this.fragmentAssembler = new FragmentAssembler(this::onFragment);
    }

    @Builder
    public static SubscriptionReader build(Subscription subscription, MessageListener messageListener) {
        SubscriptionReader reader = new SubscriptionReader(subscription, messageListener);
        return reader;
    }

    public void tryReadMessage() {
//        log.info("polling message");
        subscription.poll(this.fragmentAssembler, 10);
    }

    void onFragment(DirectBuffer buffer, int offset, int length, Header header)  {
        try {
            byte[] bytes = new byte[length];
            buffer.getBytes(offset, bytes);

            MessageWrapper wrapper = MessageWrapper.parseFrom(bytes);
            Image image = subscription.imageBySessionId(header.sessionId());
            messageListener.onMessage(image.sourceIdentity(), wrapper);
        } catch (Exception e) {
            log.error("Parse message error sessionId={} streamId={}", header.sessionId(), header.streamId(), e);
        }
    }
}

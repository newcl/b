package info.chenliang.b;

import info.chenliang.b.message.MessageWrapper;
import io.aeron.FragmentAssembler;
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
        subscription.poll(this.fragmentAssembler, 10);
    }

    void onFragment(DirectBuffer buffer, int offset, int length, Header header)  {
        try {
            MessageWrapper wrapper = MessageWrapper.parseFrom(buffer.byteArray());
            subscription.imageBySessionId(header.sessionId()).sourceIdentity();
            messageListener.onMessage(wrapper);
        } catch (Exception e) {
            log.error("Parse message error sessionId={} streamId={}", header.sessionId(), header.streamId(), e);
        }
    }
}
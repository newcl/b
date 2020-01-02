package info.chenliang.b;

import info.chenliang.b.generated.message.MessageWrapper;

public interface MessageListener {
    void onMessage(String identity, MessageWrapper wrapper);
}

package info.chenliang.b;

import info.chenliang.b.message.MessageWrapper;

public interface MessageListener {
    void onMessage(MessageWrapper wrapper);
}

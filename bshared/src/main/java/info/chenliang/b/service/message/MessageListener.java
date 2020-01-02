package info.chenliang.b.service.message;

import info.chenliang.b.generated.message.MessageWrapper;

public interface MessageListener {
    void onMessage(MessageWrapper messageWrapper);
}

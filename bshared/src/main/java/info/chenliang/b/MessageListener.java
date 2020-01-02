package info.chenliang.b;

import info.chenliang.b.generated.message.MessageWrapper;
import info.chenliang.b.service.message.Address;

public interface MessageListener {
    void onMessage(Address from, MessageWrapper wrapper);
}

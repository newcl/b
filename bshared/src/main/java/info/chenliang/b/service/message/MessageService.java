package info.chenliang.b.service.message;

import info.chenliang.b.MessageListener;
import info.chenliang.b.generated.message.MessageWrapper;

public interface MessageService {
    void send(Address address, MessageWrapper messageWrapper);
    void receive(Address address, MessageListener listener);
}

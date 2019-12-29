package info.chenliang.b.message;

import info.chenliang.b.MessageListener;

public interface MessageService {
    void send(Address address, MessageWrapper messageWrapper);
    void receive(Address address, MessageListener listener);
}

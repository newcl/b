package core.net;

public interface Transport {
    void addObserver(MessageObserver messageObserver);
    void send(Message message);
}

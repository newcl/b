package core.net;

public interface Message {
    MessageSender getMessageSender();
    MessageReceiver getMessageReceiver();
}

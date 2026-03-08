package messaging;

import java.util.Arrays;
import java.util.List;

public class CompositeSender implements MessageSender {
    private List<MessageSender> senders;

    public CompositeSender(MessageSender... senders) {
        this.senders = Arrays.asList(senders);
    }

    @Override
    public SendResult send(String message) {
        for (MessageSender sender : senders) {
            sender.send(message);
        }
        return new SendResult(true, null);
    }
}

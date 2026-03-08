package messaging;

public class SlackService implements MessageSender {
    @Override
    public SendResult send(String message) {
        System.out.println("슬랙 메시지 발송: " + message);
        return new SendResult(true, null);
    }
}

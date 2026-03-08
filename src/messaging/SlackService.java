package messaging;

// 2. 메일 발송 전문가
public class SlackService implements MessageSender {
    public SendResult send(String message) { /* 이메일 발송 */
        System.out.println("슬랙 발송: " + message);
        return new SendResult(true, null);
    }
}

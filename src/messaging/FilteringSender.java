package messaging;

public class FilteringSender implements MessageSender {
    private final MessageSender target;

    public FilteringSender(MessageSender target) { this.target = target; }

    @Override
    public SendResult send(String message) {
        String filtered = message.replace("hanwha", "**"); // 필터링 로직
        return target.send("[알림] " + filtered); // 실제 전송은 원본 객체에 위임
    }
}

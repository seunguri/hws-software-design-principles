package messaging;

public class KaKaoService implements MessageSender {
    public void send(String message) { /* 카톡 발송*/
        // 카카오는 메일과 달리 글자수 제한이 있다고 가정
        if (message.length() > 100) {
            // 부모의 약속(보낸다)을 어기고 예외를 던짐
            throw new RuntimeException("카톡은 100자 이상 보낼 수 없습니다!");
        }
        System.out.println("카톡 발송: " + message);
    }
}

package messaging;

import di.MyDependency;

@MyDependency
public class KaKaoService implements MessageSender {
    public SendResult send(String message) { /* 카톡 발송*/
        // 카카오는 메일과 달리 글자수 제한이 있다고 가정
        if (message.length() > 100) {
            // 흐름을 끊지 않고 "실패"라는 상태를 전달
            return new SendResult(false, "카톡 제한 초과");
        }
        System.out.println("카톡 발송: " + message);
        return new SendResult(true, null);
    }
}

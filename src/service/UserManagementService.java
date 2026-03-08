package service;

import log.Logger;
import messaging.MessageSender;
import messaging.SendResult;
import repository.UserRepository;

// 4. 이제 Service는 '비즈니스 흐름'만 관리합니다.
public class UserManagementService {
    private UserRepository repository = new UserRepository();
    private final MessageSender messageSender;
    private Logger logger = new Logger();

    // 외부에서 '어떤' 전송기인지 주입(DI)받습니다.
    public UserManagementService(MessageSender sender) {
        this.messageSender = sender;
    }

    public void registerUser(String email, String password) {
        if (!email.contains("@")) return;

        repository.save(email);
        SendResult result = messageSender.send(email);
        if (!result.isSuccess()) {
            System.out.println("에러 발생: " + result.getErrorMessage());
            // 여기서 로그를 남기거나 재시도 로직을 태움
        }
        logger.log("User registered: " + email);
    }
}

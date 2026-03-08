package service;

import log.Logger;
import messaging.MessageSender;
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
        messageSender.send(email);
        logger.log("User registered: " + email);
    }
}

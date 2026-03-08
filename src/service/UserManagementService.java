package service;

import log.Logger;
import messaging.EmailService;
import messaging.MessageSender;
import repository.UserRepository;

// 4. 이제 Service는 '비즈니스 흐름'만 관리합니다.
public class UserManagementService {
    private UserRepository repository = new UserRepository();
    private MessageSender messageSender = new EmailService();
    private Logger logger = new Logger();

    public void registerUser(String email, String password) {
        if (!email.contains("@")) return;

        repository.save(email);
        messageSender.send(email);
        logger.log("User registered: " + email);
    }
}

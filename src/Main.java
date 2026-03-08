import messaging.*;
import service.UserManagementService;

public class Main {
    public static void main(String[] args) {
        UserManagementService userManagementService = new UserManagementService(
                new CompositeSender(
                        new FilteringSender(new EmailService()),
                        new FilteringSender(new SlackService()),
                        new FilteringSender(new KaKaoService())
                )
        );
        userManagementService.registerUser("hanwha@hanwha.com", "hanwha123");
    }
}

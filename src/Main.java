import messaging.FilteringSender;
import messaging.KaKaoService;
import messaging.SlackService;
import service.UserManagementService;

public class Main {
    public static void main(String[] args) {
        UserManagementService userManagementService = new UserManagementService(new FilteringSender(new SlackService()));
        userManagementService.registerUser("hanwha@hanwha.com", "hanwha123");
    }
}

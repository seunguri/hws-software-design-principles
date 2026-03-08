import messaging.KaKaoService;
import service.UserManagementService;

public class Main {
    public static void main(String[] args) {
        UserManagementService userManagementService = new UserManagementService(new KaKaoService());
        userManagementService.registerUser("hanwha@hanwha.com", "hanwha123");
    }
}

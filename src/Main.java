import di.MyContainer;
import service.UserManagementService;

public class Main {
    public static void main(String[] args) throws Exception {
        UserManagementService userManagementService = MyContainer.getBean(UserManagementService.class);
        userManagementService.registerUser("hanwha@hanwha.com", "hanwha123");
    }
}

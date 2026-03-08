import service.UserManagementService;

public class Main {
    public static void main(String[] args) {
        UserManagementService userManagementService = new UserManagementService();
        userManagementService.registerUser("hanwha@hanwha.com", "hanwha123");
    }
}

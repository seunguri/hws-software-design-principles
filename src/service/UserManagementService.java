package service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class UserManagementService {

    // 1. 회원가입 로직 (비즈니스 로직)
    public void registerUser(String email, String password) {
        if (!email.contains("@")) {
            System.out.println("잘못된 이메일 형식입니다.");
            return;
        }
        // 2. DB 연결 및 저장 (데이터 액세스 로직)
        // 만약 MySQL에서 Oracle로 바뀐다면 이 메서드를 고쳐야 함!
        System.out.println(email + " 사용자를 DB에 저장 중...");
        String connectionString = "jdbc:mysql://localhost:3306/mydb";
        // ... 실제 DB 저장 코드 ...

        // 3. 환영 메일 발송 (알림 로직)
        // 메일 엔진이 바뀌거나 카카오톡으로 변경된다면 또 여기를 고쳐야 함!
        System.out.println(email + "에게 환영 메일을 발송합니다.");
        // ... SMTP 메일 발송 코드 ...

        // 4. 로그 파일 기록 (로깅 로직)
        // 로그 포맷이 바뀌거나 파일 위치가 바뀌면 또 여기를 고쳐야 함!
        try (FileWriter fw = new FileWriter("log.txt", true)) {
            fw.write("User registered: " + email + " at " + LocalDateTime.now() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

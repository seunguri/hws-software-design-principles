package messaging;

// 1. 공통 결과 객체 정의
public class SendResult {
    private final boolean isSuccess;
    private final String errorMessage;

    public SendResult(boolean isSuccess, String errorMessage) {
        this.isSuccess = isSuccess;
        this.errorMessage = errorMessage;
    }
    public boolean isSuccess() { return isSuccess; }
    public String getErrorMessage() { return errorMessage; }
}

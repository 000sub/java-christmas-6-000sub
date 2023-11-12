package christmas.exception;

public enum Exceptions {
    INVALID_DATE_MESSAGE("유효하지 않은 날짜입니다."),
    INVALID_ORDER_MESSAGE("유효하지 않은 주문입니다.");

    private static final String prefix = "[ERROR] ";
    private static final String postfix = " 다시 입력해 주세요.";

    private final String message;

    Exceptions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message + postfix;
    }
}

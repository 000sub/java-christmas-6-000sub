package christmas.view;

public enum ViewMessages {
    EVENT_RESULT_INIT_MESSAGE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    AMOUNT_FORMAT("%,d원%n"),
    EVENT_AND_DISCOUNT_AMOUNT_FORMAT("%s: %,d원%n"),
    MENU_NAME_AND_QUANTITY_FORMAT("%s %d개%n"),
    NO_RESULT("없음");

    private final String message;

    ViewMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}

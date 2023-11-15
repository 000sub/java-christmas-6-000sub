package christmas.domain.dto.request;

import static christmas.exception.Exceptions.INVALID_ORDER_MESSAGE;

public class OrderedItemRequestDto {
    private static final int MINIMAL_MENU_NAME_LENGTH = 1;
    private static final int MINIMAL_QUANTITY = 1;
    private static final String FORMAT_SEPARATOR = "-";

    private final String menuName;
    private final int quantity;

    private OrderedItemRequestDto(String menuName, int quantity) {
        this.menuName = menuName;
        this.quantity = quantity;
        validateNameLength();
        validateQuantity();
    }

    public static OrderedItemRequestDto create(String menuInput) {
        validateInputFormat(menuInput);
        String menuName = menuInput.split(FORMAT_SEPARATOR)[0];
        int quantity = parseInt(menuInput.split(FORMAT_SEPARATOR)[1]);
        return new OrderedItemRequestDto(menuName, quantity);
    }

    private static void validateInputFormat(String input) {
        if (input.split(FORMAT_SEPARATOR).length != 2) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE.getMessage());
        }
    }

    private void validateNameLength() {
        if (menuName.length() < MINIMAL_MENU_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE.getMessage());
        }
    }

    private void validateQuantity() {
        if (quantity < MINIMAL_QUANTITY) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE.getMessage());
        }
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INVALID_ORDER_MESSAGE.getMessage());
        }
    }

    public String getMenuName() {
        return menuName;
    }

    public int getQuantity() {
        return quantity;
    }
}

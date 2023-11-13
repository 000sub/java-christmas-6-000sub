package christmas.domain.dto.request;

import static christmas.exception.Exceptions.INVALID_ORDER_MESSAGE;

public class OrderedItemRequestDto {
    private final String menuName;
    private final int quantity;

    public OrderedItemRequestDto(String menuName, int quantity) {
        validateNameLength(menuName);
        validateQuantity(quantity);
        this.menuName = menuName;
        this.quantity = quantity;
    }

    public static OrderedItemRequestDto create(String menuInput) {
        validateInputFormat(menuInput);
        String menuName = menuInput.split("-")[0];
        int quantity = parseInt(menuInput.split("-")[1]);
        return new OrderedItemRequestDto(menuName, quantity);
    }

    private static void validateInputFormat(String input) {
        if (input.split("-").length != 2) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE.getMessage());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE.getMessage());
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity < 1) {
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

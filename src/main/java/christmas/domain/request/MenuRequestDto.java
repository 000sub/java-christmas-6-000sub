package christmas.domain.request;

public class MenuRequestDto {
    private final String menuName;
    private final int quantity;

    public MenuRequestDto(String menuName, int quantity) {
        validateNameLength(menuName);
        validateQuantity(quantity);
        this.menuName = menuName;
        this.quantity = quantity;
    }

    public static MenuRequestDto create(String menuInput) {
        validateInputFormat(menuInput);
        String menuName = menuInput.split("-")[0];
        int quantity = parseInt(menuInput.split("-")[1]);
        return new MenuRequestDto(menuName, quantity);
    }

    private static void validateInputFormat(String input) {
        if (input.split("-").length != 2) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException();
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException();
        }
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}

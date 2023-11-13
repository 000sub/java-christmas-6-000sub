package christmas.domain;

import java.util.Objects;

public class OrderedItem {
    private final Menu menu;
    private final int quantity;

    public OrderedItem(String name, int quantity) {
        this.menu = Menu.from(name);
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return menu.getPrice() * quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderedItem that = (OrderedItem) o;
        return getMenu() == that.getMenu();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMenu());
    }
}

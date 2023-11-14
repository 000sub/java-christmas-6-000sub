package christmas.domain;

import java.util.Objects;

public class Item {
    protected final Menu menu;
    protected final int quantity;

    protected Item(String name, int quantity) {
        this.menu = Menu.from(name);
        this.quantity = quantity;
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
        Item item = (Item) o;
        return menu == item.menu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu);
    }
}

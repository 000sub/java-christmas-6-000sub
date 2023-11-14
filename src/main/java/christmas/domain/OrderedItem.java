package christmas.domain;

public class OrderedItem extends Item {

    public OrderedItem(String name, int quantity) {
        super(name, quantity);
    }

    public int getTotalPrice() {
        return menu.getPrice() * quantity;
    }

}

package christmas.domain;

public class GiftItem extends Item {
    public GiftItem(String name, int quantity) {
        super(name, quantity);
    }

    public static GiftItem of(Menu menu, int quantity) {
        return new GiftItem(menu.getName(), quantity);
    }

    public int getTotalValue() {
        return quantity * menu.getPrice();
    }
}

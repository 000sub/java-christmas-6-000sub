package christmas.domain;

public class RewardItem extends Item {
    public RewardItem(String name, int quantity) {
        super(name, quantity);
    }

    public int getTotalValue() {
        return quantity * menu.getPrice();
    }
}

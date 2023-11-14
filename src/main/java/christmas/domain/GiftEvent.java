package christmas.domain;

public class GiftEvent extends Event {
    private static final int MINIMUM_TOTAL_AMOUNT = 120000;

    @Override
    public boolean canApply(Order order) {
        return order.getTotalAmount() > MINIMUM_TOTAL_AMOUNT;
    }

    public Menu getGift() {
        return Menu.CHAMPAGNE;
    }
}

package christmas.domain;

import static christmas.domain.MenuCategory.DESSERT;

public class WeekdayDiscountEvent extends DiscountEvent {
    private static final int UNIT_DISCOUNT_AMOUNT = 2023;

    @Override
    public int getDiscountAmount(Order order) {
        int quantityOfDessert = order.getQuantityOfCategory(DESSERT);
        return quantityOfDessert * UNIT_DISCOUNT_AMOUNT;
    }

    @Override
    public boolean canApply(Order order) {
        return false;
    }
}

package christmas.domain;

import java.util.List;

public class SpecialDiscountEvent extends DiscountEvent {
    private static final List<Integer> SPECIAL_DAYS = List.of(3, 10, 17, 24, 25, 31);
    private static final int FIXED_DISCOUNT_AMOUNT = 1000;

    @Override
    protected int calculateDiscountAmount(Order order) {
        return FIXED_DISCOUNT_AMOUNT;
    }

    @Override
    protected boolean isEligible(Order order) {
        return SPECIAL_DAYS.contains(order.getVisitDate().getDayOfMonth());
    }
}

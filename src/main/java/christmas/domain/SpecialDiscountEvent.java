package christmas.domain;

import java.util.List;

public class SpecialDiscountEvent extends DiscountEvent {
    private static final List<Integer> STAR_DAYS = List.of(3, 10, 17, 24, 25, 31);
    private static final int DISCOUNT_AMOUNT = 1000;

    @Override
    public int getDiscountAmount(Order order) {
        return DISCOUNT_AMOUNT;
    }

    @Override
    public boolean canApply(Order order) {
        int date = order.getVisitDate().getDayOfMonth();
        return STAR_DAYS.contains(date);
    }
}

package christmas.domain;

import static christmas.domain.MenuCategory.MAIN;

import java.time.DayOfWeek;

public class WeekendDiscountEvent extends DiscountEvent {
    private static final int UNIT_DISCOUNT_AMOUNT = 2023;

    @Override
    protected int calculateDiscountAmount(Order order) {
        int quantityOfMain = order.getQuantityOfCategory(MAIN);
        return quantityOfMain * UNIT_DISCOUNT_AMOUNT;
    }

    @Override
    protected boolean isEligible(Order order) {
        return isWeekend(order.getVisitDate().getDayOfWeek());
    }

    private boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }


}

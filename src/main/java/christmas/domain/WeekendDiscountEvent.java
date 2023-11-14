package christmas.domain;

import static christmas.domain.MenuCategory.MAIN;

import java.time.DayOfWeek;

public class WeekendDiscountEvent extends DiscountEvent {
    private static final int UNIT_DISCOUNT_AMOUNT = 2023;

    @Override
    public int getDiscountAmount(Order order) {
        int quantityOfMain = order.getQuantityOfCategory(MAIN);
        return quantityOfMain * UNIT_DISCOUNT_AMOUNT;
    }

    @Override
    public boolean canApply(Order order) {
        return isWeekend(order.getVisitDate().getDayOfWeek());
    }

    private boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }
}

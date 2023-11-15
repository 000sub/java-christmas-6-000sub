package christmas.domain;

import static christmas.domain.MenuCategory.MAIN;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendDiscountEvent extends DiscountEvent {
    private static final int UNIT_DISCOUNT_AMOUNT = 2023;

    @Override
    protected int calculateDiscountAmount(Order order) {
        int quantityOfMain = order.getQuantityOfCategory(MAIN);
        return quantityOfMain * UNIT_DISCOUNT_AMOUNT;
    }

    @Override
    protected boolean isEligible(Order order) {
        return isWeekend(order.getVisitDate());
    }

    private boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return WEEKEND.contains(dayOfWeek);
    }


}

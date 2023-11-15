package christmas.domain;

import static christmas.domain.MenuCategory.DESSERT;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayDiscountEvent extends DiscountEvent {
    private static final int UNIT_DISCOUNT_AMOUNT = 2023;

    @Override
    protected int calculateDiscountAmount(Order order) {
        int quantityOfDessert = order.getQuantityOfCategory(DESSERT);
        return quantityOfDessert * UNIT_DISCOUNT_AMOUNT;
    }

    @Override
    protected boolean isEligible(Order order) {
        return isWeekday(order.getVisitDate());
    }

    private boolean isWeekday(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return !WEEKEND.contains(dayOfWeek);
    }


}

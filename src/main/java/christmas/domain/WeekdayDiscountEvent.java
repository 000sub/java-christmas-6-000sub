package christmas.domain;

import static christmas.domain.MenuCategory.DESSERT;

import java.time.DayOfWeek;

public class WeekdayDiscountEvent extends DiscountEvent {
    private static final int UNIT_DISCOUNT_AMOUNT = 2023;

    @Override
    protected int calculateDiscountAmount(Order order) {
        int quantityOfDessert = order.getQuantityOfCategory(DESSERT);
        return quantityOfDessert * UNIT_DISCOUNT_AMOUNT;
    }

    @Override
    protected boolean isEligible(Order order) {
        return isWeekday(order.getVisitDate().getDayOfWeek());
    }

    private boolean isWeekday(DayOfWeek dayOfWeek) {
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }


}

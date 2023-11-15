package christmas.domain;

import static christmas.domain.Constants.CURRENT_MONTH;
import static christmas.domain.Constants.CURRENT_YEAR;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;

public class ChristmasDiscountEvent extends DiscountEvent {
    private static final LocalDate START_DATE = LocalDate.of(CURRENT_YEAR.getValue(), CURRENT_MONTH.getValue(), 1);
    private static final LocalDate END_DATE = LocalDate.of(CURRENT_YEAR.getValue(), CURRENT_MONTH.getValue(), 25);
    private static final int INIT_AMOUNT = 1000;
    private static final int ACCUMULATED_DISCOUNT_AMOUNT = 100;

    @Override
    protected int calculateDiscountAmount(Order order) {
        LocalDate date = order.getVisitDate();
        return INIT_AMOUNT + (int) (DAYS.between(START_DATE, date)) * ACCUMULATED_DISCOUNT_AMOUNT;
    }

    @Override
    protected boolean isEligible(Order order) {
        return isWithinDateRange(order.getVisitDate());
    }

    private boolean isWithinDateRange(LocalDate date) {
        return !date.isBefore(START_DATE) && !date.isAfter(END_DATE);
    }


}

package christmas.domain;

import static christmas.domain.Constants.CURRENT_MONTH;
import static christmas.domain.Constants.CURRENT_YEAR;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public abstract class Event {
    private static final int MINIMAL_PAY_AMOUNT_FOR_EVENT = 10000;
    private static final LocalDate START_DATE = LocalDate.of(CURRENT_YEAR.getValue(), CURRENT_MONTH.getValue(), 1);
    private static final LocalDate END_DATE = LocalDate.of(CURRENT_YEAR.getValue(), CURRENT_MONTH.getValue(), 31);
    protected static final List<DayOfWeek> WEEKEND = List.of(FRIDAY, SATURDAY);

    public final boolean canApply(Order order) {
        return isMoreThanMinimalAmount(order.getTotalAmount())
                && isWithinPeriod(order.getVisitDate())
                && isEligible(order);
    }

    protected abstract boolean isEligible(Order order);

    private boolean isMoreThanMinimalAmount(int orderAmount) {
        return MINIMAL_PAY_AMOUNT_FOR_EVENT <= orderAmount;
    }

    private boolean isWithinPeriod(LocalDate date) {
        return !date.isBefore(START_DATE) && !date.isAfter(END_DATE);
    }
}

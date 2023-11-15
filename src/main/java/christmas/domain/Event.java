package christmas.domain;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;

import java.time.DayOfWeek;
import java.util.List;

public abstract class Event {
    private static final int MINIMAL_PAY_AMOUNT_FOR_EVENT = 10000;
    protected static final List<DayOfWeek> WEEKEND = List.of(FRIDAY, SATURDAY);

    public final boolean canApply(Order order) {
        return MINIMAL_PAY_AMOUNT_FOR_EVENT <= order.getTotalAmount() && isEligible(order);
    }

    protected abstract boolean isEligible(Order order);
}

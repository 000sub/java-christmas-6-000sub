package christmas.domain;

import static christmas.domain.Constants.MINIMAL_PAY_AMOUNT_FOR_EVENT;

public abstract class Event {

    public final boolean canApply(Order order) {
        return MINIMAL_PAY_AMOUNT_FOR_EVENT.getValue() <= order.getTotalAmount() && isEligible(order);
    }

    protected abstract boolean isEligible(Order order);
}

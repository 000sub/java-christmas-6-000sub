package christmas.domain;

public abstract class Event {
    private static final int MINIMAL_PAY_AMOUNT_FOR_EVENT = 10000;

    public final boolean canApply(Order order) {
        return MINIMAL_PAY_AMOUNT_FOR_EVENT <= order.getTotalAmount() && isEligible(order);
    }

    protected abstract boolean isEligible(Order order);
}

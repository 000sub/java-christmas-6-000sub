package christmas.domain;

public abstract class DiscountEvent extends Event {


    public final int getDiscountAmount(Order order) {
        if (!canApply(order)) {
            return 0;
        }
        return calculateDiscountAmount(order);
    }

    protected abstract int calculateDiscountAmount(Order order);
}

package christmas.domain;

public abstract class DiscountEvent extends Event {
    public abstract int getDiscountAmount(Order order);
}

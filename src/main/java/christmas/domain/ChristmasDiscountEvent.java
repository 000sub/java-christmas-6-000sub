package christmas.domain;

public class ChristmasDiscountEvent extends DiscountEvent {
    private static final int START_DATE = 1;
    private static final int END_DATE = 25;
    private static final int INIT_AMOUNT = 1000;
    private static final int ACCUMULATED_DISCOUNT_AMOUNT = 100;

    @Override
    public boolean canApply() {
        return false;
    }

    public int getDiscountAmount(int date) {
        return INIT_AMOUNT + (date - START_DATE) * ACCUMULATED_DISCOUNT_AMOUNT;
    }

    private boolean checkEligibleDate(int date) {
        return date >= START_DATE && date <= END_DATE;
    }
}

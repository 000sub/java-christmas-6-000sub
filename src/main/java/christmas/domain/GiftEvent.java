package christmas.domain;

import static christmas.domain.Menu.CHAMPAGNE;

import java.util.Collections;
import java.util.List;

public class GiftEvent extends Event {
    private static final int MINIMUM_TOTAL_AMOUNT = 120000;

    @Override
    protected boolean isEligible(Order order) {
        return MINIMUM_TOTAL_AMOUNT <= order.getTotalAmount();
    }

    public List<GiftItem> getGifts(Order order) {
        if (!canApply(order)) {
            return Collections.emptyList();
        }
        return List.of(GiftItem.of(CHAMPAGNE, 1));
    }
}

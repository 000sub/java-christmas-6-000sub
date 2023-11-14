package christmas.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class EventResult {
    private final Order order;

    public EventResult(Order order) {
        this.order = order;
    }

    public int getTotalRewardAmount() {
        return getTotalDiscountAmount() + getTotalGiftsValue();
    }

    public Map<EventManager, Integer> getRewardDetails() {
        EnumMap<EventManager, Integer> resultsPerEvent = new EnumMap<EventManager, Integer>(EventManager.class);
        Arrays.stream(EventManager.values())
                .forEach(manager -> {
                    int appliedDiscount = manager.applyDiscount(order);
                    if (appliedDiscount > 0) {
                        resultsPerEvent.put(manager, appliedDiscount);
                    }
                });

        Arrays.stream(EventManager.values())
                .forEach(manager -> {
                    Integer totalGiftValue = manager.applyGift(order).stream()
                            .map(GiftItem::getTotalValue)
                            .reduce(0, Integer::sum);

                    if (totalGiftValue > 0) {
                        resultsPerEvent.put(manager, totalGiftValue);
                    }
                });
        return resultsPerEvent;
    }

    public int getTotalDiscountAmount() {
        return Arrays.stream(EventManager.values())
                .map(manager -> manager.applyDiscount(order))
                .reduce(0, Integer::sum);
    }

    public DecemberBadge getBadge() {
        int totalRewardAmount = getTotalRewardAmount();
        return DecemberBadge.from(totalRewardAmount);
    }

    public List<GiftItem> getGifts() {
        return Arrays.stream(EventManager.values())
                .flatMap(manager -> manager.applyGift(order).stream())
                .toList();
    }

    public int getTotalGiftsValue() {
        return getGifts().stream()
                .map(GiftItem::getTotalValue)
                .reduce(0, Integer::sum);
    }

    public int getExpectedPayAmount() {
        return order.getTotalAmount() - getTotalDiscountAmount();
    }

}

package christmas.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EventResult {
    private final Order order;

    public EventResult(Order order) {
        this.order = order;
    }

    public int getTotalRewardAmount() {
        return getTotalDiscountAmount() + getTotalGiftsValue();
    }

    public Map<EventManager, Integer> getRewardDetails() {
        return Arrays.stream(EventManager.values())
                .collect(Collectors.toMap(
                        Function.identity(),
                        manager -> manager.applyDiscount(order) + manager.applyGiftValue(order),
                        Integer::sum,
                        () -> new EnumMap<>(EventManager.class)
                ));
    }

    public int getTotalDiscountAmount() {
        return Arrays.stream(EventManager.values())
                .mapToInt(manager -> manager.applyDiscount(order))
                .sum();
    }

    public DecemberBadge getBadge() {
        int totalRewardAmount = getTotalRewardAmount();
        return DecemberBadge.from(totalRewardAmount);
    }

    public List<GiftItem> getGifts() {
        return Arrays.stream(EventManager.values())
                .flatMap(manager -> manager.applyGift(order).stream())
                .collect(Collectors.toUnmodifiableList());
    }

    public int getTotalGiftsValue() {
        return getGifts().stream()
                .mapToInt(GiftItem::getTotalValue)
                .sum();
    }

    public int getExpectedPayAmount() {
        return order.getTotalAmount() - getTotalDiscountAmount();
    }

}

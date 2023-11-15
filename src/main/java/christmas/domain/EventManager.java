package christmas.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public enum EventManager {

    WEEKDAY_DISCOUNT_EVENT(new WeekdayDiscountEvent(), "평일 할인"),
    WEEKEND_DISCOUNT_EVENT(new WeekendDiscountEvent(), "주말 할인"),
    CHRISTMAS_DISCOUNT_EVENT(new ChristmasDiscountEvent(), "크리스마스 디데이 할인"),
    STAR_DAY_DISCOUNT_EVENT(new SpecialDiscountEvent(), "특별 할인"),
    GIFT_EVENT(new GiftEvent(), "증정 이벤트");


    private Event event;
    private final String description;


    EventManager(Event event, String description) {
        this.event = event;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    private final Function<Order, Integer> discountFunction = order -> {
        if (this.event instanceof DiscountEvent) {
            return ((DiscountEvent) this.event).getDiscountAmount(order);
        }
        return 0;
    };

    private final Function<Order, List<GiftItem>> giftFunction = order -> {
        if (this.event instanceof GiftEvent) {
            return ((GiftEvent) this.event).getGifts(order);
        }
        return Collections.emptyList();
    };

    private final Function<Order, Integer> giftValueFunction = order -> {
        if (this.event instanceof GiftEvent) {
            return ((GiftEvent) this.event).getGifts(order).stream()
                    .mapToInt(GiftItem::getTotalValue)
                    .sum();
        }
        return 0;
    };

    public int applyDiscount(Order order) {
        return discountFunction.apply(order);
    }

    public List<GiftItem> applyGift(Order order) {
        return giftFunction.apply(order);
    }

    public int applyGiftValue(Order order) {
        return giftValueFunction.apply(order);
    }
}

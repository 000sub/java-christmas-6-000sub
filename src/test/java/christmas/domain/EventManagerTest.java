package christmas.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EventManagerTest {
    private final int WEEKDAY_DATE = 3;
    private final OrderedItem MAIN_MENU = new OrderedItem(Menu.T_BONE_STEAK.getName(), 5);
    private final OrderedItem DESSERT_MENU = new OrderedItem(Menu.CHOCOLATE_CAKE.getName(), 5);
    private final OrderedItem BEVERAGE_MENU = new OrderedItem(Menu.ZERO_COKE.getName(), 5);
    private final Order testOrder = Order.of(WEEKDAY_DATE, List.of(MAIN_MENU, DESSERT_MENU, BEVERAGE_MENU));

    @Test
    void 할인이벤트에_증정품_요청시_빈리스트_반환() {
        EventManager giftEventManager = EventManager.WEEKEND_DISCOUNT_EVENT;

        List<GiftItem> giftItems = giftEventManager.applyGifts(testOrder);

        Assertions.assertThat(giftItems).isEmpty();
    }

    @Test
    void 증정이벤트에_할인_요청시_0원_반환() {
        EventManager giftEventManager = EventManager.GIFT_EVENT;

        int appliedDiscount = giftEventManager.applyDiscount(testOrder);

        Assertions.assertThat(appliedDiscount).isEqualTo(0);
    }
}
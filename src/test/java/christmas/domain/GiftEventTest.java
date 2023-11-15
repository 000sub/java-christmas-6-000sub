package christmas.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GiftEventTest {
    @Test
    void 금액_조건_충족시_샴페인_지급() {
        List<OrderedItem> orderedItems = new ArrayList<>();
        orderedItems.add(new OrderedItem(Menu.T_BONE_STEAK.getName(), 20));
        Order order = Order.of(3, orderedItems);
        int totalAmount = order.getTotalAmount();
        System.out.println("totalAmount = " + totalAmount);

        GiftEvent giftEvent = new GiftEvent();
        List<GiftItem> gifts = giftEvent.getGifts(order);

        Assertions.assertThat(gifts.get(0).getMenu()).isEqualTo(Menu.CHAMPAGNE);
    }

    @Test
    void 금액_조건_미충족시_증정품_미지급() {
        List<OrderedItem> orderedItems = new ArrayList<>();
        orderedItems.add(new OrderedItem(Menu.T_BONE_STEAK.getName(), 1));
        Order order = Order.of(3, orderedItems);
        int totalAmount = order.getTotalAmount();
        System.out.println("totalAmount = " + totalAmount);

        GiftEvent giftEvent = new GiftEvent();
        List<GiftItem> gifts = giftEvent.getGifts(order);

        Assertions.assertThat(gifts).isEmpty();
    }
}
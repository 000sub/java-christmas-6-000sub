package christmas.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ChristmasDiscountEventTest {

    ChristmasDiscountEvent christmasDiscountEvent = new ChristmasDiscountEvent();

    private Order getTestOrder(int date) {
        OrderedItem orderedItem = new OrderedItem("크리스마스파스타", 1);
        List<OrderedItem> orderedItems = List.of(orderedItem);
        return Order.of(date, orderedItems);
    }

    @Test
    void 첫날_할인_금액은_1000원() {

        int discountAmount = christmasDiscountEvent.getDiscountAmount(getTestOrder(1));

        Assertions.assertThat(discountAmount).isEqualTo(1000);
    }

    @Test
    void 마지막날_할인_금액은_3400원() {
        int discountAmount = christmasDiscountEvent.getDiscountAmount(getTestOrder(25));

        Assertions.assertThat(discountAmount).isEqualTo(3400);
    }

    @Test
    void 기간외_할인_금액은_0원() {
        int discountAmount = christmasDiscountEvent.getDiscountAmount(getTestOrder(29));

        Assertions.assertThat(discountAmount).isEqualTo(0);
    }
}
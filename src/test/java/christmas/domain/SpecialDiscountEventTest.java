package christmas.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SpecialDiscountEventTest {
    private static final List<Integer> SPECIAL_DAYS = List.of(3, 10, 17, 24, 25, 31);

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void 해당하는_날짜에_1000원_할인_적용(int value) {
        OrderedItem orderedItem = new OrderedItem(Menu.BARBECUE_LIP.getName(), 3);
        List<OrderedItem> orderedItems = List.of(orderedItem);
        Order order = Order.of(value, orderedItems);

        SpecialDiscountEvent specialDiscountEvent = new SpecialDiscountEvent();
        int discountAmount = specialDiscountEvent.getDiscountAmount(order);

        Assertions.assertThat(discountAmount).isEqualTo(1000);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 5})
    void 해당되지_않는_날짜에_할인_미적용(int value) {
        OrderedItem orderedItem = new OrderedItem(Menu.BARBECUE_LIP.getName(), 3);
        List<OrderedItem> orderedItems = List.of(orderedItem);
        Order order = Order.of(value, orderedItems);

        SpecialDiscountEvent specialDiscountEvent = new SpecialDiscountEvent();
        int discountAmount = specialDiscountEvent.getDiscountAmount(order);

        Assertions.assertThat(discountAmount).isEqualTo(0);
    }
}

package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OrderTest {
    @Test
    void 총_주문_비용_구하기() {
        OrderedItem orderedItem = new OrderedItem(Menu.BARBECUE_LIP.getName(), 3);
        List<OrderedItem> orderedItems = List.of(orderedItem);
        Order order = Order.of(25, orderedItems);

        int totalAmount = order.getTotalAmount();

        Assertions.assertThat(totalAmount).isEqualTo(Menu.BARBECUE_LIP.getPrice() * 3);
    }

    @Test
    void 중복_메뉴_주문_예외_처리() {
        OrderedItem orderedItem = new OrderedItem(Menu.ZERO_COKE.getName(), 2);
        OrderedItem orderedItem2 = new OrderedItem(Menu.ZERO_COKE.getName(), 1);

        List<OrderedItem> orderedItems = List.of(orderedItem, orderedItem2);

        assertThatThrownBy(() -> Order.of(2, orderedItems))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,35", "20,1", "10,11"})
    void 최대_수량_초과_주문_예외_처리(int first, int second) {
        OrderedItem orderedItem = new OrderedItem(Menu.ZERO_COKE.getName(), first);
        OrderedItem orderedItem2 = new OrderedItem(Menu.ZERO_COKE.getName(), second);

        List<OrderedItem> orderedItems = List.of(orderedItem, orderedItem2);

        assertThatThrownBy(() -> Order.of(2, orderedItems))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
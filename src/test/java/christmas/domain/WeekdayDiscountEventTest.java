package christmas.domain;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class WeekdayDiscountEventTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2023", "10,20230", "2,4046"})
    void 디저트_하나당_2023원_할인_적용(int value, int expected) {
        List<OrderedItem> orderedItems = new ArrayList<>();
        orderedItems.add(new OrderedItem(Menu.CHOCOLATE_CAKE.getName(), value));
        orderedItems.add(new OrderedItem(Menu.ZERO_COKE.getName(), 5));
        orderedItems.add(new OrderedItem(Menu.T_BONE_STEAK.getName(), 3));
        Order order = Order.of(3, orderedItems);

        WeekdayDiscountEvent weekdayDiscountEvent = new WeekdayDiscountEvent();
        int discountAmount = weekdayDiscountEvent.getDiscountAmount(order);

        Assertions.assertThat(discountAmount).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void 주말_금토_할인_미적용(int value) {
        List<OrderedItem> orderedItems = new ArrayList<>();
        orderedItems.add(new OrderedItem(Menu.CHOCOLATE_CAKE.getName(), 10));
        orderedItems.add(new OrderedItem(Menu.ZERO_COKE.getName(), 5));
        orderedItems.add(new OrderedItem(Menu.T_BONE_STEAK.getName(), 3));
        Order order = Order.of(value, orderedItems);

        DayOfWeek dayOfWeek = order.getVisitDate().getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);

        WeekdayDiscountEvent weekdayDiscountEvent = new WeekdayDiscountEvent();
        int discountAmount = weekdayDiscountEvent.getDiscountAmount(order);

        Assertions.assertThat(discountAmount).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 10})
    void 주말_금토_제외_할인_적용(int value) {
        List<OrderedItem> orderedItems = new ArrayList<>();
        orderedItems.add(new OrderedItem(Menu.CHOCOLATE_CAKE.getName(), 10));
        orderedItems.add(new OrderedItem(Menu.ZERO_COKE.getName(), 5));
        orderedItems.add(new OrderedItem(Menu.T_BONE_STEAK.getName(), 3));
        Order order = Order.of(value, orderedItems);

        DayOfWeek dayOfWeek = order.getVisitDate().getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);

        WeekdayDiscountEvent weekdayDiscountEvent = new WeekdayDiscountEvent();
        int discountAmount = weekdayDiscountEvent.getDiscountAmount(order);

        Assertions.assertThat(discountAmount).isEqualTo(10 * 2023);
    }

}
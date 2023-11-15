package christmas.domain;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class EventResultTest {
    private final int WEEKDAY_DATE = 3;
    private final OrderedItem MAIN_MENU = new OrderedItem(Menu.T_BONE_STEAK.getName(), 5);
    private final OrderedItem DESSERT_MENU = new OrderedItem(Menu.CHOCOLATE_CAKE.getName(), 5);
    private final OrderedItem BEVERAGE_MENU = new OrderedItem(Menu.ZERO_COKE.getName(), 5);
    private final List<DiscountEvent> discountEvents = List.of(new WeekendDiscountEvent(),
            new WeekdayDiscountEvent(), new SpecialDiscountEvent(), new ChristmasDiscountEvent());
    private final Order testOrder = Order.of(WEEKDAY_DATE, List.of(MAIN_MENU, DESSERT_MENU, BEVERAGE_MENU));
    private final EventResult eventResult = new EventResult(testOrder);

    @Test
    void 총혜택_금액은_증정품_가격과_총할인_금액의_합() {
        int totalDiscount = discountEvents.stream().mapToInt(event -> event.getDiscountAmount(testOrder)).sum();
        int champagnePrice = Menu.CHAMPAGNE.getPrice();

        int totalRewardAmount = eventResult.getTotalRewardAmount();

        Assertions.assertThat(totalRewardAmount).isEqualTo(totalDiscount + champagnePrice);
    }

    @Test
    void 총혜택_금액에_따라_배지_획득() {
        DecemberBadge badge = eventResult.getBadge();
        System.out.println("badge = " + badge.getName());

        Assertions.assertThat(badge).isInstanceOf(DecemberBadge.class);
    }

    @ParameterizedTest
    @EnumSource()
    void 이벤트별_혜택_금액_반환(EventManager manager) {
        Map<EventManager, Integer> rewardDetails = eventResult.getRewardDetails();
        int discount = rewardDetails.get(manager);
        System.out.println("manager = " + manager);
        System.out.println("discount = " + discount);
        Assertions.assertThat(discount).isGreaterThanOrEqualTo(0);
    }

    @Test
    void 총할인_금액_계산() {
        int expected = discountEvents.stream().mapToInt(event -> event.getDiscountAmount(testOrder)).sum();

        int actual = eventResult.getTotalDiscountAmount();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 증정품_가격_계산() {
        int champagnePrice = Menu.CHAMPAGNE.getPrice();

        int totalGiftsValue = eventResult.getTotalGiftsValue();

        Assertions.assertThat(totalGiftsValue).isEqualTo(champagnePrice);
    }

    @Test
    void 증정품_샴폐인_받아오기() {
        GiftItem giftItem = eventResult.getGifts().get(0);

        Assertions.assertThat(giftItem.getMenu()).isEqualTo(Menu.CHAMPAGNE);
    }

    @Test
    void 예상_결제_금액은_할인_전_금액과_총할인_금액의_차() {
        int amountBeforeDiscount = testOrder.getTotalAmount();
        int totalDiscount = discountEvents.stream().mapToInt(event -> event.getDiscountAmount(testOrder)).sum();

        int expectedAmount = eventResult.getExpectedPayAmount();

        Assertions.assertThat(expectedAmount).isEqualTo(amountBeforeDiscount - totalDiscount);
    }
}
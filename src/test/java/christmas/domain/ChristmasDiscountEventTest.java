package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ChristmasDiscountEventTest {

    ChristmasDiscountEvent christmasDiscountEvent = new ChristmasDiscountEvent();

    @Test
    void 첫날_할인_금액은_1000원() {
        int discountAmount = christmasDiscountEvent.getDiscountAmount(1);

        Assertions.assertThat(discountAmount).isEqualTo(1000);
    }

    @Test
    void 마지막날_할인_금액은_3400원() {
        int discountAmount = christmasDiscountEvent.getDiscountAmount(25);

        Assertions.assertThat(discountAmount).isEqualTo(3400);
    }

    @Test
    void 기간외_할인_금액은_0원() {
        int discountAmount = christmasDiscountEvent.getDiscountAmount(29);

        Assertions.assertThat(discountAmount).isEqualTo(0);
    }
}
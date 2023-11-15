package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DecemberBadgeTest {

    @ParameterizedTest
    @CsvSource(value = {"4999,없음", "5000,별", "10000,트리", "20000,산타"})
    void 금액별로_다른_배지_지급(int amount, String name) {
        DecemberBadge badge = DecemberBadge.from(amount);

        String badgeName = badge.getName();

        Assertions.assertThat(badgeName).isEqualTo(name);

    }
}
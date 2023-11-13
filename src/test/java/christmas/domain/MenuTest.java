package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuTest {
    @ParameterizedTest
    @ValueSource(strings = {"냉면", "사이다", "탕후루"})
    void 이름이_존재하지_않는_메뉴_생성_예외_처리(String input) {
        Assertions.assertThatThrownBy(() -> Menu.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크", "레드와인", "해산물파스타"})
    void 이름이_존재하는_메뉴_정상_생성(String input) {
        Menu menu = Menu.from(input);

        Assertions.assertThat(menu).isInstanceOf(Menu.class);
    }
}
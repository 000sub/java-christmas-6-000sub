package christmas.domain.request;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.dto.request.MenuRequestDto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuRequestDtoTest {

    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-0"})
    void 수량_0이면_생성_실패(String input) {
        assertThatThrownBy(() -> MenuRequestDto.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc-", "abc-as", "콜라-한개"})
    void 사용자_입력수량_숫자_아니면_생성_실패(String input) {
        assertThatThrownBy(() -> MenuRequestDto.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"레드와인_1", "레드와인-1-1-1", "레드와인1", "레드와인-", "-2", "-", "", "---"})
    void 유효한_형식이_아니면_생성_실패(String input) {
        assertThatThrownBy(() -> MenuRequestDto.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"레드와인-1", "제로콜라-20"})
    void 유효한_형식이면_생성_성공(String input) {
        assertThat(MenuRequestDto.create(input)).isInstanceOf(MenuRequestDto.class);
    }
}
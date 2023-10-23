package baseball.domain.number;

import baseball.domain.player.number.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NumberTest {

    @ParameterizedTest
    @MethodSource("provideOutOfRangeValues")
    @DisplayName("1~9 범위를 벗어난 수가 입력될 경우 Exception이 발생해야 한다.")
    void createExceptionByOutOfRange(int number) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Number.from(number))
                .withMessageMatching("1~9 사이의 값만 입력하여야 합니다.");
    }
     static Stream<Arguments> provideOutOfRangeValues() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(10),
                Arguments.of(25));
     }
}
package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("숫자에 1 ~ 9 범위 이외의 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"1,2,10", "2,45,3", "100, 12, 1"})
    void createPlayerByInvalidRangeNumber(int number1, int number2, int number3) {
        assertThatThrownBy(() -> new Player(List.of(number1, number2, number3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자의 개수가 3개를 넘어가면 예외가 발생한다.")
    @Test
    void createPlayerByOverSize() {
        assertThatThrownBy(() -> new Player(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Player(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자의 개수가 3개보다 적으면 예외가 발생한다.")
    @Test
    void createPlayerByUnderSize() {
        assertThatThrownBy(() -> new Player(List.of(1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Player(List.of(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"1,2,1", "2,3,3", "1, 1, 1"})
    void createPlayerByDuplicatedNumber(int number1, int number2, int number3) {
        assertThatThrownBy(() -> new Player(List.of(number1, number2, number3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("getNumberOf 메서드는 플레이어의 수에서 해당 위치에 있는 숫자를 반환한다.")
    @ParameterizedTest
    @CsvSource({"0,1", "1,2", "2,3"})
    void numberOf(int index, int expected) {
        Player player = new Player(List.of(1, 2, 3));
        int result = player.numberOf(index);

        assertThat(result).isEqualTo(expected);
    }
}
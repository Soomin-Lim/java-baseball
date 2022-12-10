package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class ComputerTest {

    Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer(List.of(1, 2, 3));
    }

    @DisplayName("match 메서드는 컴퓨터의 수와 플레이어의 수를 비교해 둘 다에 포함되어있는 숫자의 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,2,3,3", "1,2,5,2", "1,6,7,1", "7,8,9,0"})
    void match(int number1, int number2, int number3, int expected) {
        Player player = new Player(List.of(number1, number2, number3));

        int result = computer.match(player);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
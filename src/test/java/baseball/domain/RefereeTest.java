package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    Computer computer = new Computer(List.of(1, 2, 3));
    Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @DisplayName("compare 메서드는 컴퓨터의 수(3자리)와 플레이어의 수(3자리)를 비교한 결과를 문자열로 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,2,3,3스트라이크", "7,8,9,낫싱", "2,3,1,3볼", "1,3,2,2볼 1스트라이크"})
    void compare(int number1, int number2, int number3, String expected) {
        Player player = new Player(List.of(number1, number2, number3));

        String result = referee.compare(computer, player);

        assertThat(result).isEqualTo(expected);
    }
}
package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class RefereeTest {

    private static final List<Integer> ANSWER = List.of(1, 2, 3);
    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @DisplayName("compare() 메서드가 올바른 값을 반환하는 지 검증한다.")
    @CsvSource({"1,2,3,3스트라이크", "7,8,9,낫싱", "2,3,1,3볼", "1,3,9,1볼 1스트라이크"})
    @ParameterizedTest
    void compare(int number1, int number2, int number3, String expected) {
        String actual = referee.compare(ANSWER, List.of(number1, number2, number3));

        assertThat(actual).isEqualTo(expected);
    }
}
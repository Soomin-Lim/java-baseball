package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    Player player;

    @BeforeEach
    void setUp() {
        player = new Player(List.of(1, 2, 3));
    }

    @DisplayName("getNumberOf 메서드는 플레이어의 수에서 해당 위치에 있는 숫자를 반환한다.")
    @ParameterizedTest
    @CsvSource({"0,1", "1,2", "2,3"})
    void numberOf(int index, int expected) {
        int result = player.numberOf(index);

        assertThat(result).isEqualTo(expected);
    }
}
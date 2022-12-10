package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @DisplayName("createRandomNumbers 메서드는 1 ~ 9 범위의 중복되지 않는 숫자 3개를 생성한다.")
    @Test
    void createRandomNumbers() {
        NumberGenerator numberGenerator = new NumberGenerator();

        List<Integer> result = numberGenerator.createRandomNumbers();

        for (int number : result) {
            assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
        }
        assertThat(result).hasSize(3);
        assertThat(result).doesNotHaveDuplicates();
    }
}
package baseball.domain;

import java.util.*;

public class Player {

    private final List<Integer> numbers;

    public Player(List<Integer> numbers) {
        validatePlayerInput(numbers);

        this.numbers = numbers;
    }

    public void validatePlayerInput(List<Integer> numbers) {
        validateRange(numbers);
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < 1 || number > 9)) {
            throw new IllegalArgumentException("1부터 9까지의 숫자여야 합니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 3)
            throw new IllegalArgumentException("숫자 3개를 입력해야 합니다.");
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> numberStorage = new HashSet<>(numbers);
        if (numberStorage.size() != 3) {
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해야 합니다.");
        }
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }

    public int size() {
        return numbers.size();
    }
}

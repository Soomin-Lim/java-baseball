package baseball.domain;

import java.util.*;

public class Player {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int NUMBERS_SIZE = 3;

    public static final String NUMBER_RANGE_ERROR_MESSAGE = MINIMUM_NUMBER + "부터 " + MAXIMUM_NUMBER+ " 사이의 숫자여야 합니다.";
    public static final String NUMBERS_SIZE_ERROR_MESSAGE = "숫자 " + NUMBERS_SIZE +"개를 입력해야 합니다.";
    public static final String NUMBER_DUPLICATE_ERROR_MESSAGE = "숫자는 서로 중복되지 않아야 합니다.";

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
                .anyMatch(number -> number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER)) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE)
            throw new IllegalArgumentException(NUMBERS_SIZE_ERROR_MESSAGE);
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> numberStorage = new HashSet<>(numbers);
        if (numberStorage.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public int numberOf(int index) {
        return numbers.get(index);
    }

    public int size() {
        return numbers.size();
    }
}

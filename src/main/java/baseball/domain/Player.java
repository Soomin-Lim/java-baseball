package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<Integer> numbers;

    public Player(String input) {
        validatePlayerInput(input);

        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split("")) {
            numbers.add(Integer.parseInt(number));
        }

        this.numbers = numbers;
    }

    public void validatePlayerInput(String input) {
        validateNumberFormat(input);
        validateSize(input);
        validateDuplication(input);
    }

    private void validateNumberFormat(String input) {
        for (String number : input.split("")) {
            if (!Character.isDigit(number.charAt(0))) {
                throw new IllegalArgumentException("숫자 이외의 문자는 입력받지 않습니다.");
            }
        }
    }

    private void validateSize(String input) {
        if (input.length() != 3)
            throw new IllegalArgumentException("숫자 3개를 입력해야 합니다.");
    }

    private void validateDuplication(String input) {
        char firstNum = input.charAt(0);
        char secondNum = input.charAt(1);
        char thirdNum = input.charAt(2);
        if (firstNum == secondNum || secondNum == thirdNum || thirdNum == firstNum)
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해야 합니다.");
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }

    public int size() {
        return numbers.size();
    }
}

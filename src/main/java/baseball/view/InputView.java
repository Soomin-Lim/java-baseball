package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public List<Integer> readPlayerNumbers() {
        return convertStringToNumbers(Console.readLine());
    }

    public int readGameCommand() {
        return convertStringToInteger(Console.readLine());
    }

    private List<Integer> convertStringToNumbers(String input) {
        try {
            String[] numbers = input.split("");
            return Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private int convertStringToInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }


}

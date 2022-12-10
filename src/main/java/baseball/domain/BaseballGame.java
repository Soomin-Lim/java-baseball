package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private Referee referee;

    public String play(List<Integer> computer) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        List<Integer> user = getUserNumberList(input);

        referee = new Referee();
        String gameResult = referee.compare(computer, user);
        return gameResult;

    }

    public boolean isCompleted() {
        return referee.isThreeStrike();
    }

    public List<Integer> getUserNumberList(String input) {
        validateUserInput(input);

        List<Integer> user = new ArrayList<>();
        for (String number : input.split("")) {
            user.add(Integer.parseInt(number));
        }

        return user;
    }

    public void validateUserInput(String input) {
        for (String number : input.split("")) {
            if (!Character.isDigit(number.charAt(0))) {
                throw new IllegalArgumentException("숫자 이외의 문자는 입력받지 않습니다.");
            }
        }

        if (input.length() != 3)
            throw new IllegalArgumentException("숫자 3개를 입력해야 합니다.");

        char firstNum = input.charAt(0);
        char secondNum = input.charAt(1);
        char thirdNum = input.charAt(2);
        if (firstNum == secondNum || secondNum == thirdNum || thirdNum == firstNum)
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해야 합니다.");
    }

}

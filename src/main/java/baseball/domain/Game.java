package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int RESTART = 1;
    private static final int EXIT = 2;

    private boolean gameExit = false;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!gameExit) {
            NumberGenerator numberGenerator = new NumberGenerator();
            List<Integer> computer = numberGenerator.createRandomNumbers();
            playGame(computer);
        }
    }

    public void playGame(List<Integer> computer) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            List<Integer> user = getUserNumberList(input);

            Referee referee = new Referee();
            String gameResult = referee.compare(computer, user);
            printResult(gameResult);

            if (referee.isThreeStrike()) {
                restartOrExit();
                break;
            }
        }
    }

    public List<Integer> getRandomNumberList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
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

    public void printResult(String gameResult) {
        System.out.println(gameResult);
    }

    public void restartOrExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();
        validateUserExitInput(input);

        int choose = Integer.parseInt(input);

        if (choose == EXIT)
            gameExit = true;
    }

    public void validateUserExitInput(String input) {
        if (input.length() != 1 || !Character.isDigit(input.charAt(0)))
            throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");

        int choose = Integer.parseInt(input);
        if (choose != RESTART && choose != EXIT)
            throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");
    }

}

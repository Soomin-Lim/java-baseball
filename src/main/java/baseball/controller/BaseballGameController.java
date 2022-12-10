package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.NumberGenerator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGameController {

    private static final int RESTART = 1;
    private static final int EXIT = 2;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            BaseballGame game = new BaseballGame();
            playGame(game);
            int choose = restartOrExit();

            if (choose == EXIT)
                break;
        }
    }

    public void playGame(BaseballGame game) {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> computer = numberGenerator.createRandomNumbers();

        while (true) {
            boolean completed = game.play(computer);
            if (completed) {
                break;
            }
        }
    }

    public int restartOrExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();
        validateUserExitInput(input);

        return Integer.parseInt(input);
    }

    public void validateUserExitInput(String input) {
        if (input.length() != 1 || !Character.isDigit(input.charAt(0)))
            throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");

        int choose = Integer.parseInt(input);
        if (choose != RESTART && choose != EXIT)
            throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");
    }
}

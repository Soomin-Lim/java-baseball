package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {

    private static final int RESTART = 1;
    private static final int EXIT = 2;

    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        outputView.printStartMessage();

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

        do {
            outputView.printInputMessage();
            String playerNumbers = inputView.readPlayerNumbers();
            List<Integer> player = createPlayer(playerNumbers);
            String gameResult = game.play(computer, player);
            outputView.printGameResult(gameResult);

        } while (!game.isCompleted());
    }

    private List<Integer> createPlayer(String input) {
        validateUserInput(input);

        List<Integer> player = new ArrayList<>();
        for (String number : input.split("")) {
            player.add(Integer.parseInt(number));
        }

        return player;
    }

    public void validateUserInput(String input) {
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

    public int restartOrExit() {
        outputView.printRestartOrExitMessage();

        int command = inputView.readGameCommand();
        validateUserExitCommand(command);
        return command;
    }

    public void validateUserExitCommand(int command) {
        if (command != RESTART && command != EXIT)
            throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");
    }
}

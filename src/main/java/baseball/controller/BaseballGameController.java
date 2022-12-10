package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
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

        while (true) {
            String gameResult = game.play(computer);
            outputView.printGameResult(gameResult);

            if (game.isCompleted()) {
                break;
            }
        }
    }

    public int restartOrExit() {
        outputView.printRestartOrExitMessage();

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

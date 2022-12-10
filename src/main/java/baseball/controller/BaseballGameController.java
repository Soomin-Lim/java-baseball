package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.Computer;
import baseball.domain.NumberGenerator;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

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
        List<Integer> computerNumbers = numberGenerator.createRandomNumbers();
        Computer computer = new Computer(computerNumbers);

        while (true) {
            outputView.printInputMessage();
            List<Integer> playerNumbers = inputView.readPlayerNumbers();
            Player player = createPlayer(playerNumbers);

            String gameResult = game.play(computer, player);
            outputView.printGameResult(gameResult);

            if (game.isCompleted()) {
                break;
            }
        }
    }

    private Player createPlayer(List<Integer> playerNumbers) {
        return new Player(playerNumbers);
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

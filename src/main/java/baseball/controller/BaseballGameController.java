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
    private static final String GAME_COMMAND_ERROR_MESSAGE = RESTART + " 또는 " + EXIT + "만 입력할 수 있습니다.";

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

            int command = restartOrExit();
            if (command == EXIT)
                break;
        }
    }

    public void playGame(BaseballGame game) {
        NumberGenerator numberGenerator = new NumberGenerator();
        Computer computer = new Computer(numberGenerator.createRandomNumbers());

        do {
            outputView.printInputMessage();
            List<Integer> playerNumbers = inputView.readPlayerNumbers();
            Player player = createPlayer(playerNumbers);

            String gameResult = game.play(computer, player);
            outputView.printGameResult(gameResult);

        } while (!game.isSuccess());
    }

    private Player createPlayer(List<Integer> playerNumbers) {
        return new Player(playerNumbers);
    }


    public int restartOrExit() {
        outputView.printRestartOrExitMessage();

        int command = inputView.readGameCommand();
        validateGameCommand(command);
        return command;
    }

    public void validateGameCommand(int command) {
        if (command != RESTART && command != EXIT)
            throw new IllegalArgumentException(GAME_COMMAND_ERROR_MESSAGE);
    }
}

package baseball.view;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_EXIT_COMMAND_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printInputMessage() {
        System.out.print(NUMBER_INPUT_MESSAGE);
    }

    public void printGameResult(String result) {
        System.out.println(result);
    }

    public void printRestartOrExitMessage() {
        System.out.println(GAME_SUCCESS_MESSAGE);
        System.out.println(RESTART_OR_EXIT_COMMAND_INPUT_MESSAGE);
    }
}

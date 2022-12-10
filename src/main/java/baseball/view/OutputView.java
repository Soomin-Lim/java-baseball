package baseball.view;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String EXIT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_EXIT_CHOOSE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printGameResult(String result) {
        System.out.println(result);
    }

    public void printRestartOrExitMessage() {
        System.out.println(EXIT_MESSAGE);
        System.out.println(RESTART_EXIT_CHOOSE_MESSAGE);
    }
}

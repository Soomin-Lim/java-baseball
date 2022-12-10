package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readPlayerNumbers() {
        return Console.readLine();
    }

    public int readGameCommand() {
        return convertStringToInteger(Console.readLine());
    }

    private int convertStringToInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}

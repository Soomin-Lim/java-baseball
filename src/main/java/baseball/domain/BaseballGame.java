package baseball.domain;

import java.util.List;

public class BaseballGame {

    private Referee referee;

    public String play(Computer computer, Player player) {
        referee = new Referee();

        String gameResult = referee.compare(computer, player);
        return gameResult;
    }

    public boolean isCompleted() {
        return referee.isThreeStrike();
    }

}

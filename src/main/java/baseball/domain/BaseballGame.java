package baseball.domain;

public class BaseballGame {

    private Referee referee;

    public String play(Computer computer, Player player) {
        referee = new Referee();

        return referee.compare(computer, player);
    }

    public boolean isSuccess() {
        return referee.isThreeStrike();
    }

}

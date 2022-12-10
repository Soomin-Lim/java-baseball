package baseball.domain;

public class Referee {

    private int strike = 0;
    private int ball = 0;

    public String compare(Computer computer, Player player) {
        int matchCount = computer.match(player);

        for (int index = 0; index < player.size(); index++) {
            if (computer.numberOf(index) == player.numberOf(index)) {
                strike++;
            }
        }
        ball = matchCount - strike;

        return createCompareResult();
    }

    private String createCompareResult() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        if (ball != 0 && strike != 0) {
            return ball + "볼 " + strike + "스트라이크";
        }
        if (ball != 0) {
            return ball + "볼";
        }
        return strike + "스트라이크";
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }
}

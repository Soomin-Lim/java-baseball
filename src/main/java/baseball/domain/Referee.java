package baseball.domain;

import java.util.List;

public class Referee {

    private int strike = 0;
    private int ball = 0;

    public String compare(List<Integer> computer, List<Integer> player) {
        Judgement judgement = new Judgement();

        int correctCount = judgement.correctCount(computer, player);
        for (int placeIndex = 0; placeIndex < player.size(); placeIndex++) {
            if (judgement.hasPlace(computer, placeIndex, player.get(placeIndex))) {
                strike++;
            }
        }
        ball = correctCount - strike;

        return createCompareResult(strike, ball);
    }

    private String createCompareResult(int strike, int ball) {
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

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

        String result = "";
        if (ball != 0)
            result += ball + "볼 ";
        if (strike != 0)
            result += strike + "스트라이크";
        return result;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }
}

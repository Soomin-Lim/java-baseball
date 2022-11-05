package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    static final int RESTART = 1;
    static final int EXIT = 2;

    static int strike = 0;
    static int ball = 0;
    static boolean gameEnd = false;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computer = getRandomNumberList();
            if (!playGame(computer)) break;
        }

    }

    private boolean playGame(List<Integer> computer) {
        gameEnd = false;

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            List<Integer> user = new ArrayList<>();
            for (String s : Arrays.asList(input.split(""))) {
                user.add(Integer.parseInt(s));
            }

            calculateNumber(user, computer);
            printResult();

            if (gameEnd) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int choose = Integer.parseInt(Console.readLine());

                if (choose == RESTART) return true;
                if (choose == EXIT) return false;
            }
        }
    }

    private static List<Integer> getRandomNumberList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static void calculateNumber(List<Integer> user, List<Integer> computer) {
        strike = 0;
        ball = 0;

        for (int number : user) {
            int userIndex = user.indexOf(number);
            int computerIndex = computer.indexOf(number);

            if (userIndex == computerIndex) {
                strike++;
            }
            else if (computerIndex != -1) {
                ball++;
            }
        }
    }

    private static void printResult() {
        if (strike == 0 && ball == 0)
            System.out.println("낫싱");
        if (ball != 0)
            System.out.println(ball + "볼 ");
        if (strike != 0)
            System.out.println(strike + "스트라이크");

        if (strike == 3)
            gameEnd = true;
    }

}

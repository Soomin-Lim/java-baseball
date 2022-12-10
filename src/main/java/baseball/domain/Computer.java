package baseball.domain;

import java.util.List;

public class Computer {

    private final List<Integer> numbers;

    public Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int match(Player player) {
        int result = 0;
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.contains(player.getNumber(index))) {
                result++;
            }
        }
        return result;
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }
}

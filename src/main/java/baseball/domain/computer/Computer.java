package baseball.domain.computer;

import baseball.domain.player.number.Number;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.domain.player.number.Number.MAX_NUMBER;
import static baseball.domain.player.number.Number.MIN_NUMBER;
import static baseball.domain.player.number.Player.BASEBALL_NUMBERS_LIMIT_SIZE;
import static baseball.domain.player.number.Player.integerToNumber;

public class Computer {
    private List<Number> answerNumbers;

    private Computer(List<Number> numbers) {
        this.answerNumbers = numbers;
    }

    public static Computer createComputerAnswerByRandomGenerator() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != BASEBALL_NUMBERS_LIMIT_SIZE) {
            numbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
        List<Number> answerNumbers = integerToNumber(new ArrayList<>(numbers));
        return new Computer(answerNumbers);
    }

    public List<Number> getAnswerNumbers() {
        return answerNumbers;
    }
}

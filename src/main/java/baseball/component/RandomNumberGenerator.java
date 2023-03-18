package baseball.component;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int BOUND = 9;
    private static final int SIZE_OF_NUMBER = 3;
    private final Random random = new Random();
    private StringBuilder number;

    public Number generateNumber() {
        number = new StringBuilder();

        for (int i = 0; i < SIZE_OF_NUMBER; i++) {
            int element = makeRandomInt();

            if (isAlreadyExist(element)) {
                i--;
                continue;
            }

            number.append(element);
        }

        return Number.from(number.toString());
    }

    private int makeRandomInt() {
        return random.nextInt(BOUND) + 1;
    }

    private boolean isAlreadyExist(int element) {
        String stringElement = String.valueOf(element);
        return number.toString().contains(stringElement);
    }
}

package baseball.component;

import java.util.Random;

public class RandomNumbersGenerator {
    private static final int BOUND = 10;
    private static final int LENGTH = 3;
    private final Random random = new Random();
    private StringBuilder stringBuilder;

    public static RandomNumbersGenerator create() {
        return new RandomNumbersGenerator();
    }

    public Numbers generateNumbers() {
        initializeStringBuilder();
        addRandomNumbersToStringBuilder();
        return Numbers.from(getStringFromStringBuilder());
    }

    private void initializeStringBuilder() {
        stringBuilder = new StringBuilder();
    }

    private void addRandomNumbersToStringBuilder() {
        for (int index = 0; index < LENGTH; index++) {
            Integer number = makeRandomInt();
            if (isAlreadyExist(number)) {
                index--;
                continue;
            }

            stringBuilder.append(number);
        }
    }

    private String getStringFromStringBuilder() {
        return stringBuilder.toString();
    }

    private Integer makeRandomInt() {
        return random.nextInt(BOUND - 1) + 1;
    }

    private boolean isAlreadyExist(Integer number) {
        String stringNumber = String.valueOf(number);
        return stringBuilder.toString().contains(stringNumber);
    }
}

package baseball.component;

import java.util.*;
import java.util.stream.IntStream;

public class Numbers {
    private final List<Integer> numbers = new ArrayList<>();

    private Numbers(String stringNumber) {
        IntStream.range(0, stringNumber.length())
                .forEach(index -> numbers.add(toInteger(stringNumber.charAt(index))));
    }

    public static Numbers from(String stringNumber) {
        return new Numbers(stringNumber);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public Hint compare(Numbers other) {
        return getHintFrom(other.getNumbers());
    }

    private Integer toInteger(char ch) {
        return ch - '0';
    }

    private Hint getHintFrom(List<Integer> otherNumbers) {
        Hint hint = Hint.create();

        IntStream.range(0, otherNumbers.size()).forEach(otherNumberIndex -> {
            Integer otherNumber = otherNumbers.get(otherNumberIndex);
            if (isStrike(otherNumber, otherNumberIndex)) {
                hint.increaseStrikeCount();
            }
            if (isBall(otherNumber, otherNumberIndex)) {
                hint.increaseBallCount();
            }
        });

        return hint;
    }

    private boolean isStrike(Integer otherNumber, Integer otherNumberIndex) {
        return contains(otherNumber) && hasSameIndex(otherNumber, otherNumberIndex);
    }

    private boolean isBall(Integer otherNumber, Integer otherNumberIndex) {
        return contains(otherNumber) && !hasSameIndex(otherNumber, otherNumberIndex);
    }

    private boolean contains(Integer otherNumber) {
        return numbers.contains(otherNumber);
    }

    private boolean hasSameIndex(Integer otherNumber, Integer otherNumberIndex) {
        return numbers.indexOf(otherNumber) == otherNumberIndex;
    }
}

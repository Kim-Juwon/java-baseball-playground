package baseball.component;

import java.util.Arrays;

public enum FinishingStatus {
    RESTART(1),
    TERMINATE(2);

    private final int value;

    FinishingStatus(int value) {
        this.value = value;
    }

    public boolean find(int value) {
        return this.value == value;
    }

    public static boolean anyMatch(int value) {
        return Arrays.stream(values())
                .anyMatch(finishingStatus -> finishingStatus.find(value));
    }

    public static FinishingStatus from(int value) {
        return Arrays.stream(values())
                .filter(finishingStatus -> finishingStatus.find(value))
                .findFirst()
                .orElse(null);
    }
}

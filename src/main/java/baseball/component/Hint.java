package baseball.component;

public class Hint {
    private Integer strikeCount = 0;
    private Integer ballCount = 0;
    public static final int FULL_COUNT_OF_STRIKE = 3;

    public Hint() {}

    public Hint(Integer strikeCount, Integer ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static Hint create() {
        return new Hint();
    }

    public static Hint from(int strikeCount, int ballCount) {
        return new Hint(strikeCount, ballCount);
    }

    public void increaseStrikeCount() {
        ++strikeCount;
    }

    public void increaseBallCount() {
        ++ballCount;
    }

    public boolean hasOnlyStrike() {
        return strikeCount > 0 && ballCount == 0;
    }

    public boolean is3Strike() {
        return strikeCount.equals(3);
    }

    public boolean isNothing() {
        return strikeCount.equals(0) && ballCount.equals(0);
    }
}

package baseball.component;

public class Hint {
    private static final Integer ZERO = 0;
    private static final Integer THREE = 3;
    private Integer strikeCount = 0;
    private Integer ballCount = 0;

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
        return isStrikeCountPositive() && isBallCountZero();
    }

    public boolean isThreeStrike() {
        return isStrikeCountThree();
    }

    public boolean isNothing() {
        return isStrikeCountZero() && isBallCountZero();
    }

    private boolean isStrikeCountThree() {
        return strikeCount.equals(THREE);
    }

    private boolean isStrikeCountPositive() {
        return strikeCount > ZERO;
    }

    private boolean isStrikeCountZero() {
        return strikeCount.equals(ZERO);
    }

    private boolean isBallCountZero() {
        return ballCount.equals(ZERO);
    }
}

package baseball.component;

import baseball.exception.message.ExceptionMessage;
import baseball.exception.critical.InvalidHintException;

public class Hint {
    private static final int ZERO = 0;
    private static final int THREE = 3;
    private static final String STRIKE_MESSAGE = "%d스트라이크";
    private static final String BALL_MESSAGE = "%d볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private int strikeCount = 0;
    private int ballCount = 0;

    private Hint() {}

    private Hint(Integer strikeCount, Integer ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static Hint create() {
        return new Hint();
    }

    public static Hint from(int strikeCount, int ballCount) {
        return new Hint(strikeCount, ballCount);
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public String makeString() {
        if (isNothing()) {
            return NOTHING_MESSAGE;
        }
        if (isStrikeCountOnlyPositive()) {
            return String.format(STRIKE_MESSAGE, strikeCount);
        }
        if (isBallCountOnlyPositive()) {
            return String.format(BALL_MESSAGE, ballCount);
        }
        if (isStrikeCountPositive() && isBallCountPositive()) {
            return merge(String.format(STRIKE_MESSAGE, strikeCount), String.format(BALL_MESSAGE, ballCount));
        }

        throw new InvalidHintException(ExceptionMessage.HINT_IS_INVALID);
    }

    public void increaseStrikeCount() {
        ++strikeCount;
    }

    public void increaseBallCount() {
        ++ballCount;
    }

    public boolean isThreeStrike() {
        return isStrikeCountThree();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Hint)) {
            return false;
        }

        Hint other = (Hint) obj;
        return strikeCount == other.getStrikeCount()
                && ballCount == other.getBallCount();
    }

    private boolean isStrikeCountOnlyPositive() {
        return isStrikeCountPositive() && isBallCountZero();
    }

    private boolean isBallCountOnlyPositive() {
        return isStrikeCountZero() && isBallCountPositive();
    }

    private boolean isNothing() {
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

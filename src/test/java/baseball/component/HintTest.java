package baseball.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HintTest {
    static final int STRIKE_COUNT = 2;
    static final int BALL_COUNT = 1;
    Hint hint;

    @BeforeEach
    void initialize() {
        hint = Hint.from(STRIKE_COUNT, BALL_COUNT);
    }

    @Test
    @DisplayName("makeString() - 올바른 결과 문자열을 반환해야 함")
    void makeString_ShouldReturnCorrectString() {
        // when
        String actual = hint.makeString();

        // then
        String expected = "2스트라이크 1볼";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("increaseStrikeCount() - strikeCount를 1 증가시켜야 함")
    void increaseStrikeCount_ShouldBeIncreasedBy1() {
        // when
        int beforeStrikeCount = hint.getStrikeCount();
        hint.increaseStrikeCount();
        int actual = hint.getStrikeCount() - beforeStrikeCount;

        // then
        int expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("increaseBallCount() - ballCount를 1 증가시켜야 함")
    void increaseBallCount_ShouldBeIncreasedBy1() {
        // when
        int beforeBallCount = hint.getBallCount();
        hint.increaseBallCount();
        int actual = hint.getBallCount() - beforeBallCount;

        // then
        int expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("isThreeStrike() - 3스트라이크가 아니면 false를 반환해야 함")
    void isThreeStrike_ShouldBeReturnFalseWhenNotThreeStrike() {
        // when
        boolean actual = hint.isThreeStrike();

        // then
        assertThat(actual).isFalse();
    }
}
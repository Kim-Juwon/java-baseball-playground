package baseball.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumbersTest {
    Numbers numbers1;
    Numbers numbers2;

    @BeforeEach
    void initialize() {
        numbers1 = Numbers.from("372");
        numbers2 = Numbers.from("275");
    }

    @Test
    @DisplayName("hint() 메소드는 올바른 상태의 Hint 객체를 반환해야 함")
    void compare_ShouldReturnCorrectHint() {
        // when
        Hint actual = numbers1.compare(numbers2);

        // then
        Hint expected = Hint.from(1, 1);
        assertThat(actual.equals(expected)).isTrue();
    }
}
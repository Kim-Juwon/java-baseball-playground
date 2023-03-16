package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stringcalculator.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void calculate_ShouldReturnTheAccurateResult() {
        int actual = stringCalculator.calculate("2 + 3 * 4 / 2");

        assertThat(actual).isEqualTo(10);
    }
}

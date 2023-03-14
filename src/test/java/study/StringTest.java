package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual1 = "1,2".split(",");
        String[] actual2 = "1".split(",");

        assertThat(actual1).containsExactly("1", "2");
        assertThat(actual2).contains("1");
    }

    @Test
    void substring() {
        String input = "(1, 2)";
        String actual = input.substring(1, input.length() - 1);

        assertThat(actual).isEqualTo("1, 2");
    }
}

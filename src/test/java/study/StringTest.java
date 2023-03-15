package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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

    @Test
    @DisplayName("charAt() 메소드가 특정 위치의 문자를 정확히 가져오는지 확인")
    void charAt() {
        char actual = "abc".charAt(0);

        assertThat(actual).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt() 메소드 사용시 위치값을 벗어났을때 StringIndexOutOfBoundsException이 발생하는지 확인")
    void stringIndexOutBoundsExceptionForCharAt() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char ch = "abc".charAt(3);
                });
    }
}

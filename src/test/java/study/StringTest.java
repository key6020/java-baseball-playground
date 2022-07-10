package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split1() {
        // given
        String str1 = "1,2";
        String str2 = "1";

        // when
        String[] arr1 = str1.split(",");
        String[] arr2 = str2.split(",");

        // then
        assertThat(arr1).contains("1", "2");
        assertThat(arr1).containsExactly("1", "2"); // 순서까지 고려 success
//        assertThat(arr1).containsExactly("2", "1"); // 순서까지 고려 fail

        assertThat(arr2).contains("1");
        assertThat(arr2).containsExactly("1");
    }

    @Test
    void split2() {
        // given
        String str = "(1,2)";

        // when
        String subString = str.substring(1, str.length() - 1);

        // then
        assertThat(subString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() success")
    void split3() {
        // given
        String str = "abc";

        // when
        char c = str.charAt(0);

        // then
        assertThat(c).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt() StringIndexOutOfBoundsException")
    void split3_1() {
        // given
        String str = "abc";
        int idx = 5;

        // then
        assertThatThrownBy(() -> {
            char c = str.charAt(idx);
            assertThat(c).isEqualTo('b');
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("%d", idx);
    }
}

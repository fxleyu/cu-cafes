package fx.leyu.jdk.util.regex;

import org.junit.Test;

import java.util.regex.Pattern;

public class PatternTest {
    @Test
    public void test() {
        boolean x = Pattern.matches("^[\\u0100-\\u017F\\u0080-\\u00FFa-zA-Z\\s]{2,200}$", "Za");
        System.out.println(x);
        double value = 0.0015 * 0.425 + 0.002 * 0.425 + 0.0066 * 0.15;
        System.out.println(value);
    }
}

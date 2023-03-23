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

    @Test
    public void testFristName() {
        // ^(?!\s*$)[\\w\\W]{2,20}$
        boolean x = Pattern.matches("^.{2,20}$", "Zx");
        System.out.println(x);
    }

    @Test
    public void testPhone() {
        // ^[0-9\-()]{16}$
        boolean x = Pattern.matches("^[0-9\\-()]{15}$", "(01)7-3485-1241");
        System.out.println(x);
    }

    @Test
    public void testZipCode() {
        // ^[0-9\-()]{16}$
        boolean x = Pattern.matches("^[0-9]{5}-[0-9]{3}$", "00000-000");
        System.out.println(x);
    }

    @Test
    public void testCPF() {
        // ^\d{3}.\d{3}.\d{3}-\d{2}$
        boolean x = Pattern.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$", "222.333.444-12");
        System.out.println(x);
    }
}

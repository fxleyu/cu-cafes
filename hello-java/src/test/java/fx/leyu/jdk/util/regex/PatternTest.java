package fx.leyu.jdk.util.regex;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.util.PatternMatchUtils;

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
    public void testPattern() {
        String pattern = "-?[0-9]+:-?[0-9]";
        System.out.println(Pattern.matches(pattern, "-1:4"));
        System.out.println(Pattern.matches(pattern,  "1:4"));
        System.out.println(Pattern.matches(pattern, "1:4:5"));
        System.out.println(Pattern.matches(pattern, null));
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

        System.out.println(JSON.toJSONString(null));

        Object obj = JSON.parseObject("null", Object.class);
        System.out.println(obj == null);

        String str = JSONObject.parseObject(null, String.class);
        System.out.println(str);
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

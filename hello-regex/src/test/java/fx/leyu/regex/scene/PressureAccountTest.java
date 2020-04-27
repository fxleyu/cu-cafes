package fx.leyu.regex.scene;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

public class PressureAccountTest {
    @Test
    public void test() {
        // performtest000001@qq.com ~performtest700000@qq.com
        String pattern =  "performtest([0-6][0-9]{4}[1-9]|[0-6][0-9]{3}[1-9][0-9]|[0-6][0-9]{2}[1-9][0-9]{2}|[0-6][0-9][1-9][0-9]{3}|[0-6][1-9][0-9]{4}|[1-6][0-9]{5}|700000)@qq\\.com";

        Assert.assertTrue(Pattern.matches(pattern, "performtest000001@qq.com"));
        Assert.assertTrue(Pattern.matches(pattern, "performtest000011@qq.com"));
        Assert.assertTrue(Pattern.matches(pattern, "performtest000100@qq.com"));
        Assert.assertTrue(Pattern.matches(pattern, "performtest001000@qq.com"));
        Assert.assertTrue(Pattern.matches(pattern, "performtest010000@qq.com"));
        Assert.assertTrue(Pattern.matches(pattern, "performtest100000@qq.com"));
        Assert.assertTrue(Pattern.matches(pattern, "performtest700000@qq.com"));
        Assert.assertTrue(Pattern.matches(pattern, "performtest123456@qq.com"));
        Assert.assertFalse(Pattern.matches(pattern, "performtest000000@qq.com"));
        Assert.assertFalse(Pattern.matches(pattern, "performtest700001@qq.com"));
    }
}

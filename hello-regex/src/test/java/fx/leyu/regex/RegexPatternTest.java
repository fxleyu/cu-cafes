package fx.leyu.regex;

import org.junit.Assert;
import org.junit.Test;

public class RegexPatternTest {
    @Test
    public void testMetacharacter() {
        String test = "\\";
        Assert.assertTrue("file.txt".matches("file" + RegexPattern.METACHARACTER + ".txt"));
    }
}

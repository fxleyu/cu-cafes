package fx.leyu.regex;

import org.junit.Assert;
import org.junit.Test;

public class RegexPatternTest {
    @Test
    public void testMetacharacter() {
        Assert.assertTrue("file.txt".matches("file" + RegexPattern.ESCAPE_CHARACTER + ".txt"));
    }

    @Test
    public void testNetName() {
        Assert.assertTrue("fxleyu".matches(RegexPattern.NET_NAME_PATTERN));
        Assert.assertTrue("Fxleyu".matches(RegexPattern.NET_NAME_PATTERN));
        Assert.assertTrue("FxLeyu".matches(RegexPattern.NET_NAME_PATTERN));
        Assert.assertFalse("FXleyu".matches(RegexPattern.NET_NAME_PATTERN));
    }

    @Test
    public void testDotCharacter() {
        Assert.assertTrue("fxleyu".matches("fxley" + RegexPattern.DOT_CHARACTER));
        Assert.assertTrue("fxleyx".matches("fxley" + RegexPattern.DOT_CHARACTER));
    }

    @Test
    public void testMonth() {
        Assert.assertTrue("1".matches(RegexPattern.MONTH_PATTERN));
        Assert.assertTrue("9".matches(RegexPattern.MONTH_PATTERN));
        Assert.assertTrue("10".matches(RegexPattern.MONTH_PATTERN));
        Assert.assertTrue("12".matches(RegexPattern.MONTH_PATTERN));

        Assert.assertFalse("0".matches(RegexPattern.MONTH_PATTERN));
        Assert.assertFalse("13".matches(RegexPattern.MONTH_PATTERN));
        Assert.assertFalse("213".matches(RegexPattern.MONTH_PATTERN));
    }

    @Test
    public void testNotNumber() {
        Assert.assertFalse("0".matches(RegexPattern.NOT_NUMBER_PATTERN));
        Assert.assertFalse("1".matches(RegexPattern.NOT_NUMBER_PATTERN));
        Assert.assertFalse("9".matches(RegexPattern.NOT_NUMBER_PATTERN));

        Assert.assertTrue("F".matches(RegexPattern.NOT_NUMBER_PATTERN));
        Assert.assertTrue("朱".matches(RegexPattern.NOT_NUMBER_PATTERN));
    }

    @Test
    public void testArrayMark() {
        Assert.assertTrue("[0]".matches(RegexPattern.ARRAY_ZERO_MARK));
    }

    @Test
    public void test() {
        Assert.assertTrue("\\".matches("\\\\"));
    }

    @Test
    public void testReturnLine() {
        Assert.assertTrue("\n".matches("\n"));
    }

    @Test
    public void testNumberMetacharacter() {
        Assert.assertTrue("\n".matches(RegexPattern.NOT_NUMBER_METACHARACTER));
        Assert.assertTrue("Z".matches(RegexPattern.NOT_NUMBER_METACHARACTER));
        Assert.assertTrue(" ".matches(RegexPattern.NOT_NUMBER_METACHARACTER));
        Assert.assertTrue("朱".matches(RegexPattern.NOT_NUMBER_METACHARACTER));

        Assert.assertTrue("1".matches(RegexPattern.NUMBER_METACHARACTER));
    }

    @Test
    public void testWhiteMetacharacter() {
        Assert.assertTrue("\n".matches(RegexPattern.WHITE_METACHARACTER));
        Assert.assertTrue("Z".matches(RegexPattern.NOT_WHITE_METACHARACTER));
        Assert.assertTrue(" ".matches(RegexPattern.WHITE_METACHARACTER));
        Assert.assertTrue("朱".matches(RegexPattern.NOT_WHITE_METACHARACTER));
    }

    @Test
    public void testPosix() {
        Assert.assertTrue("a".matches(RegexPattern.AL_NUM_POSIX));
        Assert.assertTrue("z".matches(RegexPattern.AL_NUM_POSIX));
        Assert.assertTrue("0".matches(RegexPattern.AL_NUM_POSIX));
        Assert.assertTrue("9".matches(RegexPattern.AL_NUM_POSIX));
    }
}

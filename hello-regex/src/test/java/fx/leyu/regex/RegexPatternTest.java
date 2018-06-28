package fx.leyu.regex;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    public void testEmail() {
        Assert.assertTrue("fxleyu@qq.com".matches(RegexPattern.EMAIL_PATTERN));
        Assert.assertTrue("784978881@qq.com".matches(RegexPattern.EMAIL_PATTERN));
        Assert.assertTrue("fx_leyu@qq.com".matches(RegexPattern.EMAIL_PATTERN));

        Assert.assertFalse("朱智慧@qq.com".matches(RegexPattern.EMAIL_PATTERN));
        Assert.assertFalse("fx.leyu@qq.com".matches(RegexPattern.EMAIL_PATTERN));
    }

    @Test
    public void testMyHomePage() {
        Assert.assertTrue("https://fxleyu.github.io/".matches(RegexPattern.MY_HOME_PAGE));
        Assert.assertTrue("http://fxleyu.github.io/".matches(RegexPattern.MY_HOME_PAGE));
    }

    @Test
    public void testOnes() {
        Assert.assertTrue("111".matches(RegexPattern.THREE_ONES));
        Assert.assertTrue("111".matches(RegexPattern.THREE_TO_FIVE_ONES));
        Assert.assertTrue("111".matches(RegexPattern.AT_LEAST_THREE_ONES));

        Assert.assertFalse("1111".matches(RegexPattern.THREE_ONES));
        Assert.assertTrue("1111".matches(RegexPattern.THREE_TO_FIVE_ONES));
        Assert.assertTrue("1111".matches(RegexPattern.AT_LEAST_THREE_ONES));

        Assert.assertFalse("111111".matches(RegexPattern.THREE_TO_FIVE_ONES));
        Assert.assertTrue("111111".matches(RegexPattern.AT_LEAST_THREE_ONES));
    }

    @Test
    public void testBoldType() {
        Assert.assertTrue("<B> AK </B> and <B> HI </B>".matches(RegexPattern.BOLD_TYPE_ERROR));
        Assert.assertTrue("<B> AK </B> and <B> HI </B>".matches(RegexPattern.BOLD_TYPE)); // WTF ?

        String string = "<B> AK </B> and <B> HI </B>";
        Pattern pattern = Pattern.compile(RegexPattern.BOLD_TYPE_ERROR);
        Matcher matcher = pattern.matcher(string);
        while(matcher.find()) {
            Assert.assertEquals(string, matcher.group());
        }

        pattern = Pattern.compile(RegexPattern.BOLD_TYPE);
        matcher = pattern.matcher(string);
        while(matcher.find()) {
            Assert.assertNotEquals(string, matcher.group());
        }
    }

    @Test
    public void testFxleyu() {
        Assert.assertEquals("I am FXLEYU", "I am Fxleyu".replaceAll(RegexPattern.NET_NAME_PATTERN, "FXLEYU"));
        Assert.assertEquals("I am FXLEYU;", "I am Fxleyu;".replaceAll(RegexPattern.NET_NAME_PATTERN, "FXLEYU"));
        Assert.assertEquals("FXLEYU-!", "Fxleyu-!".replaceAll(RegexPattern.NET_NAME_PATTERN, "FXLEYU"));
        Assert.assertNotEquals("FXLEYU_-!", "Fxleyu_-!".replaceAll(RegexPattern.NET_NAME_PATTERN, "FXLEYU"));
    }

    @Test
    public void testChinese() {
        // https://github.com/fxleyu/west-world/issues/34 对 \b 的说法有问题
        Assert.assertTrue("朱".matches("\\b朱\\b"));
        Assert.assertFalse("朱".matches("\\w"));
        Assert.assertEquals("我是 朱智慧！", "我是 智慧！".replaceAll("\\b智慧\\b", "朱智慧"));
    }

    @Test
    public void testStringBoundary() {
        Assert.assertTrue("$".matches("\\$"));
        Assert.assertTrue("$a".matches("\\$a"));
        Assert.assertFalse("$a".matches("$a"));

        Assert.assertTrue("a^".matches("a\\^"));
        Assert.assertFalse("a^".matches("a^"));

        Assert.assertTrue("fxleyu".matches("^fxleyu$"));

        Assert.assertFalse("I love china! \n yes, chine.".matches("^.*$")); // . 模式不支持换行
        Assert.assertTrue("I love china! yes, chine.".matches("^.*$"));
    }

    @Test
    public void testSubexpression() {
        Assert.assertTrue("GOOD!GOOD!GOOD!".matches("(GOOD!){3,}"));

        Assert.assertTrue("19".matches("19|20\\d{2}"));
        Assert.assertTrue("2009".matches("19|20\\d{2}"));
        Assert.assertFalse("1997".matches("19|20\\d{2}"));

        Assert.assertTrue("1997".matches("(19|20)\\d{2}"));
    }

    @Test
    public void testIp() {
        Assert.assertTrue("0.1.9.10".matches(RegexPattern.IP_PATTERN));
        Assert.assertTrue("10.11.99.100".matches(RegexPattern.IP_PATTERN));
        Assert.assertTrue("100.111.199.200".matches(RegexPattern.IP_PATTERN));
        Assert.assertTrue("200.211.229.230".matches(RegexPattern.IP_PATTERN));
        Assert.assertTrue("255.250.249.230".matches(RegexPattern.IP_PATTERN));

        Assert.assertFalse("256.250.249.230".matches(RegexPattern.IP_PATTERN));
    }

    @Test
    public void testPatten0To255() {
        for (int i = 0; i < 1001; i++) {
            if (i < 256) {
                Assert.assertTrue(i + " is error", Integer.toString(i).matches(RegexPattern.PATTERN_0_255));
            } else {
                Assert.assertFalse(i + " is error", Integer.toString(i).matches(RegexPattern.PATTERN_0_255));
            }
        }
    }
}

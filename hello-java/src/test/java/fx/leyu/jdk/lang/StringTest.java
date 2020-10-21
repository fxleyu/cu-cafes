package fx.leyu.jdk.lang;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class StringTest {

    @Test
    public void testEquals() {
        String one = "Hello";
        String other = new String(one);
        Assert.assertTrue(one.equals(other));

        Assert.assertFalse(one == other);

        Assert.assertTrue(one == other.intern());
    }

    @Test
    public void testRepeatString() {
        String str = "123";
        String str3 = "123123123";
        Assert.assertEquals(str3, StringUtils.repeat(str, 3));
    }

    @Test
    public void testStringDate() {
        String str = "Sep 17, 2013";
        try {
            Date date = new SimpleDateFormat("MMMM d, yy", Locale.ENGLISH).parse(str);
            Assert.assertEquals(8, date.getMonth());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSubstring() {
        String string = "string";
        Assert.assertEquals("", string.substring(string.indexOf("g") + 1));
    }

    @Test
    public void testSplit() {
        String string = "=x";
        Assert.assertEquals(2, string.split("=").length);
        Assert.assertEquals(1, StringUtils.split(string, "=").length);
        string = "x=x";
        Assert.assertEquals(2, string.split("=").length);
        Assert.assertEquals(2, StringUtils.split(string, "=").length);

        string = "x=";
        Assert.assertEquals(1, string.split("=").length);
        Assert.assertEquals(1, StringUtils.split(string, "=").length);

        string = "";
        Assert.assertEquals(1, string.split("=").length);
        Assert.assertEquals(0, StringUtils.split(string, "=").length);

        Assert.assertEquals(null, StringUtils.split(null, "="));


        string = "=====";
        Assert.assertEquals(0, string.split("=").length);
        Assert.assertEquals(0, StringUtils.split(string, "=").length);
    }

    @Test
    public void testReplace() {
        String string = "#name# love #name#!";
        String expected = "fxleyu love fxleyu!";
        Assert.assertEquals(expected, StringUtils.replace(string, "#name#", "fxleyu"));
    }

    @Test
    public void testReplaceRichText() {
        String string = "开卡立得<font color='#ff0000'>18</font>元红包，再领20元黑卡消费金";
        String expected = "开卡立得18元红包，再领20元黑卡消费金";
        Assert.assertEquals(expected, string.replaceAll("<[^>]+>", ""));
    }
}

package fx.leyu.jdk.lang;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
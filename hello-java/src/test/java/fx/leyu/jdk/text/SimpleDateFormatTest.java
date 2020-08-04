package fx.leyu.jdk.text;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    @Test
    public void test() {
        Date date = new Date(2020, 10, 30);
        SimpleDateFormat df = new SimpleDateFormat("M.d");
        Assert.assertEquals("11.30", df.format(date));

        date = new Date(2020, 7, 4);
        Assert.assertEquals("8.4", df.format(date));
    }
}

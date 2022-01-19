package fx.leyu.jdk.lang;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.TimeZone;

public class BitOperationTest {
    @Test
    public void testAndOperation() {
        Assert.assertEquals(1, 1 & 1);
        Assert.assertEquals(0, 0 & 1);
        Assert.assertEquals(0, 0 & 2);
        Assert.assertEquals(0, 0 & 3);
        Assert.assertEquals(0, 0 & 4);

        int mode = 3;
        mode &= ~2;
        System.out.println(mode);

        Assert.assertEquals(0, (0 >> 1) & 1);
        Assert.assertEquals(0, (1 >> 1) & 1);
        Assert.assertEquals(1, (2 >> 1) & 1);
        Assert.assertEquals(1, (3 >> 1) & 1);

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        System.out.println(calendar);
        long now=calendar.getTime().getTime();

        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        System.out.println(now);
        System.out.println(calendar.getTime().getTime() - now);
    }


}

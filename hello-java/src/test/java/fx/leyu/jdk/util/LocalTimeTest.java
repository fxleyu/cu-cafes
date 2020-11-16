package fx.leyu.jdk.util;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

public class LocalTimeTest {
    @Test
    public void testCompare() {
        LocalTime localTime = LocalTime.of(20, 26);
        LocalTime before = LocalTime.parse("20:20");
        LocalTime after = LocalTime.parse("21:00");
        Assert.assertTrue(before.isBefore(localTime));
        Assert.assertTrue(after.isAfter(localTime));
    }
}

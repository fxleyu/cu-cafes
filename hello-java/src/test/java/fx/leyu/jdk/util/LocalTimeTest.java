package fx.leyu.jdk.util;

import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.TimeZone;

public class LocalTimeTest {
    @Test
    public void testCompare() {
        LocalTime localTime = LocalTime.of(20, 26);
        LocalTime before = LocalTime.parse("20:20");
        LocalTime after = LocalTime.parse("21:00");
        Assert.assertTrue(before.isBefore(localTime));
        Assert.assertTrue(after.isAfter(localTime));
    }

    @Test
    public void test() {
        System.out.println(getNextDayMsOfXHour(System.currentTimeMillis(), -1));
    }

    public static Long getNextDayMsOfXHour(long ms, int x) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(ms/1000), TimeZone.getTimeZone("GMT+08:00").toZoneId());
        int hour = localDateTime.getHour();
        int min = localDateTime.getMinute();
        int s = localDateTime.getSecond();
        return localDateTime.plusHours(24 + x - hour)
                .minusMinutes(min)
                .minusSeconds(s)
                .atZone(TimeZone.getTimeZone("GMT+08:00").toZoneId())
                .toInstant()
                .toEpochMilli();
    }
}

package fx.leyu.jdk.util;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneTest {
    @Test
    public void test() {
        TimeZone zone = TimeZone.getTimeZone("GMT-08:00");
        System.out.println(LocalDate.now(zone.toZoneId()));
        System.out.println(LocalDateTime.now(zone.toZoneId()));
        System.out.println(LocalTime.now(zone.toZoneId()));

        TimeZone timeZone = TimeZone.getTimeZone("GMT+08:00");
        LocalDateTime localDateTime = LocalDateTime.now(timeZone.toZoneId());
        int hour = localDateTime.getHour();
        int min = localDateTime.getMinute();
        int s = localDateTime.getSecond();
        System.out.println(hour);
        System.out.println(min);
        long x = localDateTime.minusHours(hour - 2)
                .minusMinutes(min)
                .minusSeconds(s)
                .atZone(timeZone.toZoneId())
                .toInstant()
                .toEpochMilli();
        System.out.println(x);
    }
}

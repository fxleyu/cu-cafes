package fx.leyu.jdk.util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    @Test
    public void test() {
        Date date = new Date(2020, 10, 31);
        SimpleDateFormat df = new SimpleDateFormat("M.d");
        System.out.println(df.format(date));
    }
}

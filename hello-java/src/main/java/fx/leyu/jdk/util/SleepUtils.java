package fx.leyu.jdk.util;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
    public static void sleepNSeconds(int s) {
        try {
            TimeUnit.SECONDS.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepNMinutes(int min) {
        try {
            TimeUnit.MINUTES.sleep(min);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

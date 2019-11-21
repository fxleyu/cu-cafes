package fx.leyu.jdk.util;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimerTest {

    @Test
    public void testSchedule() throws InterruptedException {
        // 一个时间线程
        Timer timer = new Timer("Schedule print");

        System.out.println("outer = " + System.currentTimeMillis() / 1000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("start " + System.currentTimeMillis() / 1000);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end " + System.currentTimeMillis() / 1000);
            }
        }, 1000L, 2000L);
        System.out.println("GAME OVER");
        TimeUnit.SECONDS.sleep(20);
    }
}

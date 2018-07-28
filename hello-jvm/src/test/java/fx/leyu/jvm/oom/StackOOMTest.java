package fx.leyu.jvm.oom;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class StackOOMTest {

    @Test
    public void testStackLeakByThread() throws InterruptedException {
        while (true) {
            new Thread(() -> {
                while (true) {
                    RandomUtils.nextInt();
                    try {
                        TimeUnit.MILLISECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            TimeUnit.MILLISECONDS.sleep(1000);
        }
    }
}

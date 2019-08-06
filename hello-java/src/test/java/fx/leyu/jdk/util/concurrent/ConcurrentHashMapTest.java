package fx.leyu.jdk.util.concurrent;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapTest {
    @Test
    public void testTwoThreadOperate() throws InterruptedException {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "1");
        map.put("3", "3");
        map.put("5", "5");

        CountDownLatch latch = new CountDownLatch(2);
        new Thread(() -> {
            System.out.println("for-each start");
            for(Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println("visit key is " + entry.getKey());
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("for-each end");
            latch.countDown();
        }).start();
        new Thread(() -> {
            System.out.println("add/remove start");
            map.put("2", "2");
            System.out.println("add key is 2");
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.remove("5");
            System.out.println("remove key is 5");
            System.out.println("add/remove end");
            latch.countDown();
        }).start();

        latch.await();
        /*
        for-each start
        visit key is 1
        add/remove start
        add key is 2
        visit key is 3
        remove key is 5
        add/remove end
        visit key is 5
        for-each end
        */
    }
}

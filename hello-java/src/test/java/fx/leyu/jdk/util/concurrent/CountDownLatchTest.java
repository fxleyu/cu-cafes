package fx.leyu.jdk.util.concurrent;

import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.*;

public class CountDownLatchTest {
    private static final int COUNT = 5;
    private static final int MAX_OF_SLEEP_TIME = 10;
    
    @Test
    public void test() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(COUNT);
        for (int i = 0; i < COUNT; i++) {
            runThread(latch);
        }
        latch.await();
        System.out.println("GAME OVER!");
    }

    private void runThread(CountDownLatch latch) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + this);
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(MAX_OF_SLEEP_TIME));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("Thread end " + this);
                latch.countDown();
            }
        }).start();

        ThreadPoolExecutor executorService = new ThreadPoolExecutor(5, 5, 30, TimeUnit.SECONDS,new LinkedBlockingQueue(20));
        executorService.execute(() -> {});
        executorService.execute(() -> {});
        executorService.execute(() -> {});
        executorService.execute(() -> {});
        executorService.execute(() -> {});
        executorService.execute(() -> {});
    }
}

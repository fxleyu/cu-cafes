package fx.leyu.jdk.util.concurrent;

import org.junit.Test;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

    @Test
    public void test() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 20, 3, TimeUnit.SECONDS, null);
        executor.execute(() -> { });
    }

    @Test
    public void testSynchronousQueue() throws InterruptedException {

        final SynchronousQueue<Runnable> workQueue = new SynchronousQueue<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1000, 1000, TimeUnit.SECONDS, workQueue);
        executor.execute(() -> {
            System.out.println("start 0");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end 0");
        });
        executor.execute(() -> {
            System.out.println("start 1");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end 1");
        });
        executor.execute(() -> {
            System.out.println("start 2");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end 2");
        });
        TimeUnit.SECONDS.sleep(3);
    }
}

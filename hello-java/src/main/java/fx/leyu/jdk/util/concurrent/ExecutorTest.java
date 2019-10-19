package fx.leyu.jdk.util.concurrent;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fxleyu
 */
public class ExecutorTest {

    public static void main(String[] args) {
        // Executor executor = Executors.newFixedThreadPool(2); // 错
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
                22,
                5,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new ThreadFactory() {
                    private final AtomicInteger threadNumber = new AtomicInteger(0);

                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "thread-fxleyu-" + threadNumber.incrementAndGet());
                    }
                });
        executor.execute(() -> {
            int i = 0;
            while (i++ < 6) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("this.");
        });
        executor.shutdownNow();
    }

}

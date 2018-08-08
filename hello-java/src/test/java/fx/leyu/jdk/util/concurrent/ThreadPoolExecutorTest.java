package fx.leyu.jdk.util.concurrent;

import org.junit.Test;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

    @Test
    public void test() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 20, 3, TimeUnit.SECONDS, null);
        executor.execute(() -> { });
    }
}

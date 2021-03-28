package fx.leyu.jdk.util;

import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
    private static final String KEY = "key";
    private static final String VALUE = "value";

    @Test
    public void test() throws InterruptedException {
        ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<>();
        threadLocal.set(Maps.newHashMap());
        threadLocal.get().put(KEY, VALUE);

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Assert.assertEquals(VALUE, threadLocal.get().get(KEY));
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Assert.assertEquals(VALUE, threadLocal.get().get(KEY));
        }).start();
        TimeUnit.SECONDS.sleep(5);
    }
}

package fx.leyu.cache.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadingCacheTest {
    final AtomicInteger integer = new AtomicInteger(1);
    @Test
    public void test() throws ExecutionException {
        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
            @Override
            @ParametersAreNonnullByDefault
            public String load(String key) throws Exception {
                return key + "'s value is missing";
            }
        });

        String value = loadingCache.get("key");
        Assert.assertEquals("key's value is missing", value);
    }

    @Test
    public void testGet() throws InterruptedException {


        Cache<String, String> cache  =
                CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.SECONDS).build() ;

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String value = cache.getIfPresent("key");
                if (value == null) {
                    System.out.println("key " + integer.incrementAndGet());
                    if (integer.get() % 2 == 0) {
                        value = integer.toString();
                        cache.put("key", value);
                    }
                }
                System.out.println("get"  + value);
            }
        });

        thread.start();
        thread.join();
    }
}

package fx.leyu.cache.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.TIMEOUT;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;
import java.util.concurrent.*;

public class AsyncCacheTest {
    @Test
    public void test() throws ExecutionException, InterruptedException {
        final LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                //设置并发级别为1，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(1)
                //设置缓存容器的初始容量为10
                .initialCapacity(3)
                //设置缓存最大容量为10，超过10之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(3)
                .refreshAfterWrite(10, TimeUnit.SECONDS)
                .removalListener(notification -> {
                    try {
                        System.out.println(notification.getKey() + " " + notification.getValue() + " remove by " + notification.getCause());
                    } catch (Exception exception) {
                        System.out.println("wtf IndexUserController # cache");
                    }
                })
                //.refreshAfterWrite(3, TimeUnit.SECONDS)
                //设置写缓存后n分钟过期
                .expireAfterWrite(3, TimeUnit.SECONDS)

                .build(new CacheLoader<String, String>() {
                    @Override
                    @ParametersAreNonnullByDefault
                    public String load(String key) throws Exception {
                        System.out.println("load " + key);
                        TimeUnit.SECONDS.sleep(1);
                        if (Objects.equals(key, "1")) {
                            return "null"  + System.currentTimeMillis();
                        }
                        return key +"'s value is missing" + System.currentTimeMillis();
                    }

                    /*public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
                        System.out.println();
                        if (Objects.equals(key, "1")) {
                            throw new RuntimeException();
                        }
                        System.out.println("reload " + key + " : " + oldValue );
                        return Futures.submit(() -> {
                            TimeUnit.SECONDS.sleep(1);
                            return key + " reload " + System.currentTimeMillis();
                        }, new ThreadPoolExecutor(20
                                , 20
                                , 0
                                , TimeUnit.SECONDS
                                , new LinkedBlockingQueue<>(1000)));
                    }*/
                });
        new Thread(() -> {
            try {
                String value = loadingCache.get("key");
                System.out.println("THREAD value " + value);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                String value = loadingCache.get("key");
                System.out.println("THREAD value " + value);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                String value = loadingCache.get("key");
                System.out.println("THREAD value " + value);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                String value = loadingCache.get("key");
                System.out.println("THREAD value " + value);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).start();
        System.out.println("start END ");

        String value = loadingCache.get("key");
        value = loadingCache.getIfPresent("1");
        TimeUnit.SECONDS.sleep(2);
        value = loadingCache.getIfPresent("key");
        value = loadingCache.get("1");
        value = loadingCache.get("2");
        value = loadingCache.get("3");
        value = loadingCache.get("4");
        //value = loadingCache.get("key");
        TimeUnit.SECONDS.sleep(2);
        value = loadingCache.get("key");
        loadingCache.get("1");
        value = loadingCache.get("6");
        TimeUnit.SECONDS.sleep(4);
        loadingCache.get("1");
        //Assert.assertEquals("key's value is missing", value);
    }
}

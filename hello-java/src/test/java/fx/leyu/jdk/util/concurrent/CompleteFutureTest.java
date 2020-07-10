package fx.leyu.jdk.util.concurrent;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompleteFutureTest {
    @Test
    public void test() {
        CompletableFuture<List<String>>  one = CompletableFuture.supplyAsync(() -> {
            System.out.println(System.currentTimeMillis() + " future 1 START: " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + " future 1 END: " + Thread.currentThread().getName());
            return Lists.newArrayList("one");
        });

        System.out.println(System.currentTimeMillis() + " main : " + Thread.currentThread().getName());
        System.out.println(one.join());
    }

    @Test
    public void aToB() {
        CompletableFuture<List<String>>  result = CompletableFuture.supplyAsync(() -> {
            System.out.println(System.currentTimeMillis() + " future 1 START: " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + " future 1 END: " + Thread.currentThread().getName());
            return Lists.newArrayList("one");
        }).thenApplyAsync((list) -> {
            System.out.println(System.currentTimeMillis() + " future 2 START: " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + " future 2 END: " + Thread.currentThread().getName());
            list.add("two");
            return list;
        });

        System.out.println(System.currentTimeMillis() + " main : " + Thread.currentThread().getName());
        System.out.println(result.join());
    }
}

package fx.leyu.scene;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 场景模拟
 *
 * @author fxleyu
 */
public class CompletableFutureScene {
    @Test
    public void test() {
        CompletableFuture<List<String>> userCenterFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("userCenterFuture thread = " + Thread.currentThread().getName());
            return Lists.newArrayList(Thread.currentThread().getName());
        });
        CompletableFuture<List<String>> strategyFlowFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("strategyFlowFuture thread = " + Thread.currentThread().getName());
            return Lists.newArrayList(Thread.currentThread().getName());
        });
        strategyFlowFuture = strategyFlowFuture.exceptionally(x -> Lists.newArrayList());
        List<String> result = userCenterFuture
                .thenCombineAsync(strategyFlowFuture, (userCenter, strategyFlow) -> {
            System.out.println("thenCombine thread = " + Thread.currentThread().getName());
            userCenter.addAll(strategyFlow);
            return userCenter;
        }).join();
        System.out.println(result);
    }

    @Test
    public void testSu() {
        CompletableFuture<List<String>> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("userCenterFuture thread = " + Thread.currentThread().getName());
            return Lists.newArrayList(Thread.currentThread().getName());
        });
        final AtomicInteger integer = new AtomicInteger(0);
        future.thenApply((x) -> {
            System.out.println("one = " + integer.incrementAndGet());
            return x;
        });
        future.thenApply((x) -> {
            System.out.println("two = " + integer.incrementAndGet());
            return x;
        });
        future.thenApply((x) -> {
            System.out.println("three = " + integer.incrementAndGet());
            return x;
        });
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(future.join());
    }
}

package fx.leyu.jdk.util.concurrent;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * CompleteFuture 学习
 *
 * @author fxleyu
 */
public class CompleteFutureTest {
    CompletableFuture<List<String>> ASYNC_TASK_5 = CompletableFuture.supplyAsync(() -> {
        testSleep(5);
        System.out.println((System.currentTimeMillis() / 1000) + " THREE_S_TASK: " + Thread.currentThread().getName());
        return Lists.newArrayList(" AsyncTask ");
    });

    CompletableFuture<List<String>> MAIN_TASK_0 = CompletableFuture.completedFuture(Lists.newArrayList("main"));

    Consumer<List<String>> CONSUMER_2 = x -> {
        testSleep(2);
        System.out.println((System.currentTimeMillis() / 1000) + " Consumer " + x + Thread.currentThread().getName());
    };

     Function<List<String>, String> FUNCTION_2 = (list) -> {
        testSleep(2);
         System.out.println((System.currentTimeMillis() / 1000) + " Function " + Thread.currentThread().getName());
        return list.toString();
    };

    @Test(timeout = 4500)
    public void testAcceptEither() {
        // ASYNC_TASK MAIN_TASK 先执行完的执行 Consumer 活动，Consumer活动在 main 的线程中执行
        CompletableFuture<Void> result = ASYNC_TASK_5.acceptEither(MAIN_TASK_0, CONSUMER_2);
        System.out.println((System.currentTimeMillis() / 1000) + " main : " + Thread.currentThread().getName());
        testSleep(2);
        result.join();
        System.out.println("END");
    }

    @Test(timeout = 2500)
    public void testAcceptEitherAsync() {
        // ASYNC_TASK MAIN_TASK 先执行完的执行 Consumer 活动，Consumer活动在 ForkJoinPool.commonPool 线程中执行
        CompletableFuture<Void> result = ASYNC_TASK_5.acceptEitherAsync(MAIN_TASK_0, CONSUMER_2);
        System.out.println((System.currentTimeMillis() / 1000)  + " main : " + Thread.currentThread().getName());
        testSleep(2);
        result.join();
        System.out.println("END");
    }

    @Test(timeout = 5500)
    public void testAllOf() {
        // ASYNC_TASK MAIN_TASK 均执行完
        CompletableFuture<Void> result = CompletableFuture.allOf(MAIN_TASK_0, ASYNC_TASK_5);
        result.join();
        System.out.println("END");
    }

    @Test(timeout = 500)
    public void testAnyOf() {
        // ASYNC_TASK MAIN_TASK 有一个执行完
        CompletableFuture<Object> result = CompletableFuture.anyOf(MAIN_TASK_0, ASYNC_TASK_5);
        result.join();
        System.out.println(result.join());
    }

    @Test(timeout = 4500)
    public void testApplyToEither() {
        // ASYNC_TASK MAIN_TASK 先执行完的执行 Consumer 活动，Consumer活动在 main 的线程中执行
        CompletableFuture<String> result = ASYNC_TASK_5.applyToEither(MAIN_TASK_0, FUNCTION_2);
        System.out.println((System.currentTimeMillis() / 1000) + " main : " + Thread.currentThread().getName());
        testSleep(2);
        System.out.println("result.join()");
    }

    @Test(timeout = 2500)
    public void testApplyToEitherAsync() {
        // ASYNC_TASK MAIN_TASK 先执行完的执行 Function，Consumer活动在 ForkJoinPool.commonPool 线程中执行
        CompletableFuture<String> result = ASYNC_TASK_5.applyToEitherAsync(MAIN_TASK_0, FUNCTION_2);
        System.out.println((System.currentTimeMillis() / 1000)  + " main : " + Thread.currentThread().getName());
        testSleep(2);
        System.out.println(result.join());
    }

    @Test(expected = CancellationException.class)
    public void testCancel() {
        // mayInterruptIfRunning 入参没有用
        // 中断是否执行 false
        Assert.assertFalse(MAIN_TASK_0.cancel(true));
        // 中断是否执行 true
        Assert.assertTrue(ASYNC_TASK_5.cancel(false));
        // 被中断，抛 CancellationException
        ASYNC_TASK_5.join();
    }

    @Test
    public void testComplete() {
        // 是否被触发替换操作
        Assert.assertFalse(MAIN_TASK_0.complete(null));
        Assert.assertNotNull(MAIN_TASK_0.join());

        Assert.assertTrue(ASYNC_TASK_5.complete(null));
        Assert.assertNull(ASYNC_TASK_5.join());
    }

    @Test
    public void test() {
        CompletableFuture<List<String>>  one = CompletableFuture.supplyAsync(() -> {
            System.out.println(System.currentTimeMillis() + " future 1 START: " + Thread.currentThread().getName());
            testSleep(3);
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
            testSleep(3);
            System.out.println(System.currentTimeMillis() + " future 1 END: " + Thread.currentThread().getName());
            return Lists.newArrayList("one");
        }).thenApplyAsync((list) -> {
            System.out.println(System.currentTimeMillis() + " future 2 START: " + Thread.currentThread().getName());
            testSleep(3);
            System.out.println(System.currentTimeMillis() + " future 2 END: " + Thread.currentThread().getName());
            list.add("two");
            return list;
        });

        System.out.println(System.currentTimeMillis() + " main : " + Thread.currentThread().getName());
        System.out.println(result.join());
    }


    private void testSleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

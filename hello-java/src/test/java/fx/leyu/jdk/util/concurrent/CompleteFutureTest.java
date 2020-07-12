package fx.leyu.jdk.util.concurrent;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
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
    CompletableFuture<List<String>> MAIN_OTHER_TASK_0 = CompletableFuture.completedFuture(Lists.newArrayList("main"));

    Consumer<List<String>> CONSUMER_2 = x -> {
        testSleep(2);
        System.out.println((System.currentTimeMillis() / 1000) + " Consumer " + Thread.currentThread().getName() + "; result = " + x);
    };

    BiConsumer<List<String>, List<String>> BI_CONSUMER_2 = (x, y) -> {
        testSleep(2);
        x.addAll(y);
        System.out.println((System.currentTimeMillis() / 1000) + " BiConsumer " + Thread.currentThread().getName() + "; result = " + x);
    };

    Function<List<String>, String> FUNCTION_2 = (list) -> {
        testSleep(2);
        System.out.println((System.currentTimeMillis() / 1000) + " Function " + Thread.currentThread().getName());
        return list.toString();
    };

    BiFunction<List<String>, Throwable, String> BI_FUNCTION_2 = (list, throwable) -> {
        testSleep(2);
        System.out.println((System.currentTimeMillis() / 1000) + " BiFunction " + Thread.currentThread().getName());
        if (Objects.nonNull(throwable) || CollectionUtils.size(list) < 1) {
            return "NULL";
        }
        return list.get(0);
    };

    BiFunction<List<String>, List<String>, String> BI_FUNCTION_S_S_2 = (list1, list2) -> {
        testSleep(2);
        System.out.println((System.currentTimeMillis() / 1000) + " BiFunction " + Thread.currentThread().getName());
        if (CollectionUtils.size(list1) < 1 || CollectionUtils.size(list2) < 1) {
            return "NULL";
        }
        list1.addAll(list2);
        return list1.toString();
    };

    Runnable RUNNABLE_2 = () -> {
        testSleep(2);
        System.out.println((System.currentTimeMillis() / 1000) + " Runnable " + Thread.currentThread().getName());
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

    @Test(expected = IllegalArgumentException.class)
    public void testCompleteExceptionally() throws Throwable {
        // 没有被触发替换操作
        Assert.assertFalse(MAIN_TASK_0.completeExceptionally(new IllegalArgumentException()));
        Assert.assertNotNull(MAIN_TASK_0.join());

        // 被触发，抛出定义异常
        Assert.assertTrue(ASYNC_TASK_5.completeExceptionally(new IllegalArgumentException()));
        try {
            ASYNC_TASK_5.join();
        } catch (Exception exception) {
            Throwable throwable = exception.getCause();
            Assert.assertNotNull(throwable);
            throw throwable;
        }
    }

    @Test
    public void testExceptionally() {
        // 被触发，抛出定义异常
        Assert.assertTrue(ASYNC_TASK_5.completeExceptionally(new IllegalArgumentException()));
        ASYNC_TASK_5 = ASYNC_TASK_5.exceptionally((exception) -> null);
        Assert.assertNull(ASYNC_TASK_5.join());
    }

    @Test
    public void testGetNumberOfDependents() {
        // 待完成的 CompleteFuture 个数
        Assert.assertEquals(0, ASYNC_TASK_5.getNumberOfDependents());
    }

    @Test
    public void testHandle() {
        // BI_FUNCTION_2 在 main 线程中执行
        CompletableFuture<String> stringCompletableFuture = MAIN_TASK_0.handle(BI_FUNCTION_2);
        Assert.assertEquals("main", stringCompletableFuture.join());

        // BI_FUNCTION_2 在 main 线程中执行
        Assert.assertTrue(ASYNC_TASK_5.completeExceptionally(new IllegalArgumentException()));
        stringCompletableFuture = ASYNC_TASK_5.handle(BI_FUNCTION_2);
        Assert.assertEquals("NULL", stringCompletableFuture.join());
    }

    @Test
    public void testHandleAsync() {
        // BI_FUNCTION_2 在 ForkJoinPool.commonPool 线程中执行
        CompletableFuture<String> stringCompletableFuture = MAIN_TASK_0.handleAsync(BI_FUNCTION_2);
        Assert.assertEquals("main", stringCompletableFuture.join());

        // BI_FUNCTION_2 在 ForkJoinPool.commonPool 线程中执行
        Assert.assertTrue(ASYNC_TASK_5.completeExceptionally(new IllegalArgumentException()));
        stringCompletableFuture = ASYNC_TASK_5.handleAsync(BI_FUNCTION_2);
        Assert.assertEquals("NULL", stringCompletableFuture.join());
    }

    @Test
    public void testIsCancelled() {
        // mayInterruptIfRunning 入参没有用
        // 中断是否执行 false
        Assert.assertFalse(MAIN_TASK_0.cancel(true));
        // 中断是否执行 true
        Assert.assertTrue(ASYNC_TASK_5.cancel(false));

        // 未被中断
        Assert.assertFalse(MAIN_TASK_0.isCancelled());
        // 被中断
        Assert.assertTrue(ASYNC_TASK_5.isCancelled());
    }

    @Test
    public void testIsCompletedExceptionally() {
        // 不抛异常
        Assert.assertFalse(MAIN_TASK_0.completeExceptionally(new IllegalArgumentException()));
        // 抛异常
        Assert.assertTrue(ASYNC_TASK_5.completeExceptionally(new IllegalArgumentException()));

        // 完成没有异常
        Assert.assertFalse(MAIN_TASK_0.isCompletedExceptionally());
        // 完成有异常
        Assert.assertTrue(ASYNC_TASK_5.isCompletedExceptionally());
    }

    @Test
    public void testIsCompletedExceptionally2() {
        // 完成
        Assert.assertTrue(ASYNC_TASK_5.complete(null));

        // 完成没有异常
        Assert.assertFalse(ASYNC_TASK_5.isCompletedExceptionally());
    }

    @Test
    public void testIsDone() {
        // 抛异常
        Assert.assertTrue(ASYNC_TASK_5.completeExceptionally(new IllegalArgumentException()));

        // 完成没有异常
        Assert.assertTrue(MAIN_TASK_0.isDone());
        // 完成有异常
        Assert.assertTrue(ASYNC_TASK_5.isDone());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testObtrudeException() throws Throwable {
        // 强制抛弃异常
        MAIN_TASK_0.obtrudeException(new IllegalArgumentException());
        try {
            MAIN_TASK_0.join();
        } catch (Exception exception) {
            Throwable throwable = exception.getCause();
            Assert.assertNotNull(throwable);
            throw throwable;
        }
    }

    @Test
    public void testObtrudeValue() {
        // 强制返回特定值
        MAIN_TASK_0.obtrudeValue(null);
        Assert.assertNull(MAIN_TASK_0.join());
    }

    @Test
    public void testRunAfterBoth() {
        // ASYNC_TASK_5 MAIN_TASK_0 均完成后执行 RUNNABLE_2，在最后执行完执行线程内执行？
        CompletableFuture<Void> future = MAIN_OTHER_TASK_0.runAfterBoth(MAIN_TASK_0, RUNNABLE_2);
        // 执行时间 7（main testSleep） + 2（RUNNABLE_2）
        future.join();
    }

    @Test
    public void testRunAfterBothAync() {
        // ASYNC_TASK_5 MAIN_TASK_0 均完成后执行 RUNNABLE_2，RUNNABLE_2 在 ForkJoinPool.commonPool
        CompletableFuture<Void> future = MAIN_OTHER_TASK_0.runAfterBothAsync(MAIN_TASK_0, RUNNABLE_2);
        // 执行时间 5（ASYNC_TASK_5， or main testSleep） + 2（RUNNABLE_2）
        future.join();
    }

    @Test(timeout = 4500)
    public void testRunAfterEither() {
        // ASYNC_TASK MAIN_TASK_0 先执行完的执行 RUNNABLE_2，RUNNABLE_2 在 main 线程中执行
        CompletableFuture<Void> result = ASYNC_TASK_5.runAfterEither(MAIN_TASK_0, RUNNABLE_2);
        System.out.println((System.currentTimeMillis() / 1000) + " main : " + Thread.currentThread().getName());
        testSleep(2);
        result.join();
        System.out.println("END");
    }

    @Test(timeout = 2500)
    public void testRunAfterEitherAsync() {
        // ASYNC_TASK MAIN_TASK 先执行完的执行 RUNNABLE_2，RUNNABLE_2 在 ForkJoinPool.commonPool 线程中执行
        CompletableFuture<Void> result = ASYNC_TASK_5.runAfterEitherAsync(MAIN_TASK_0, RUNNABLE_2);
        System.out.println((System.currentTimeMillis() / 1000)  + " main : " + Thread.currentThread().getName());
        testSleep(2);
        result.join();
        System.out.println("END");
    }

    @Test(timeout = 4500)
    public void testThenAccept() {
        // MAIN_TASK_0 完成后执行 CONSUMER_2，使用线程为  MAIN_TASK_0 所在线程
        CompletableFuture<Void> future = MAIN_TASK_0.thenAccept(CONSUMER_2);
        testSleep(2);
        System.out.println((System.currentTimeMillis() / 1000)  + " main : " + Thread.currentThread().getName());
        future.join();
    }

    @Test(timeout = 2500)
    public void testThenAcceptAsync() {
        // MAIN_TASK_0 完成后执行 CONSUMER_2，使用线程为  MAIN_TASK_0 所在线程
        CompletableFuture<Void> future = MAIN_TASK_0.thenAcceptAsync(CONSUMER_2);
        testSleep(2);
        System.out.println((System.currentTimeMillis() / 1000)  + " main : " + Thread.currentThread().getName());
        future.join();
    }

    @Test
    public void testThenAcceptBoth() {
        // MAIN_TASK_0 完成后执行 CONSUMER_2，使用线程为  最晚执行完所在线程
        CompletableFuture<Void> future = MAIN_TASK_0.thenAcceptBoth(ASYNC_TASK_5, BI_CONSUMER_2);
        System.out.println((System.currentTimeMillis() / 1000)  + " main : " + Thread.currentThread().getName());
        future.join();
    }

    @Test
    public void testThenAcceptBothAsync() {
        // MAIN_TASK_0 完成后执行 CONSUMER_2，使用 ForkJoinPool.commonPool 为最晚执行完所在线程
        CompletableFuture<Void> future = MAIN_TASK_0.thenAcceptBothAsync(ASYNC_TASK_5, BI_CONSUMER_2);
        System.out.println((System.currentTimeMillis() / 1000)  + " main : " + Thread.currentThread().getName());
        future.join();
    }

    @Test
    public void testThenCombine() {
        // MAIN_TASK_0 完成后执行 CONSUMER_2，使用线程为最晚执行完所在线程
        CompletableFuture<String> future = MAIN_TASK_0.thenCombine(ASYNC_TASK_5, BI_FUNCTION_S_S_2);
        System.out.println((System.currentTimeMillis() / 1000)  + " main : " + Thread.currentThread().getName());
        System.out.println(future.join());
    }

    @Test
    public void testThenCombineAysn() {
        // MAIN_TASK_0 完成后执行 CONSUMER_2，使用线程为 ForkJoinPool.commonPool
        CompletableFuture<String> future = MAIN_TASK_0.thenCombineAsync(ASYNC_TASK_5, BI_FUNCTION_S_S_2);
        System.out.println((System.currentTimeMillis() / 1000)  + " main : " + Thread.currentThread().getName());
        System.out.println(future.join());
    }

    @Test
    public void testThenApply() {
        // MAIN_TASK_0 后执行 FUNCTION_2
        MAIN_TASK_0.thenApply(FUNCTION_2)
                .join();
    }

    @Test
    public void testThenApplyAsync() {
        // MAIN_TASK_0 后执行 FUNCTION_2，FUNCTION_2 异步执行
        MAIN_TASK_0.thenApplyAsync(FUNCTION_2)
                .join();
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

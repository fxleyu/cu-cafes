package fx.leyu.jdk.util.concurrent;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class CompleteFutureTest {
    CompletableFuture<List<String>> ASYNC_TASK_5 = CompletableFuture.supplyAsync(() -> {
        testSleep(5);
        System.out.println((System.currentTimeMillis() / 1000) + " THREE_S_TASK: " + Thread.currentThread().getName());
        return Lists.newArrayList(" AsyncTask ");
    });

    CompletableFuture<List<String>> MAIN_TASK_0 = CompletableFuture.completedFuture(Lists.newArrayList("main"));
    Consumer<List<String>> CONSUMER_2 = x -> {
        testSleep(2);
        System.out.println((System.currentTimeMillis() / 1000) + " ConsumerAsync " + x + Thread.currentThread().getName());
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

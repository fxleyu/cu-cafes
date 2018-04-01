package fx.leyu.jdk.lang;

import fx.leyu.jdk.util.SleepUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadStateTest {
    @Test
    public void testStateNew() {
        Thread thread = new Thread(() -> System.out.print("Hello Thread state!"));
        Assert.assertEquals(Thread.State.NEW, thread.getState());
    }

    @Test
    public void testStateRunnable() {
        Thread thread = new Thread(() -> SleepUtils.sleepNSeconds(5));
        thread.start();

        Assert.assertEquals(Thread.State.RUNNABLE, thread.getState());
    }

    @Test
    public void testStateBlocked() {
        Object obj = new Object();

        Thread one = new Thread(() -> {
           synchronized (obj) {
               System.out.print("线程 one 获取到 obj 监视锁！");
               SleepUtils.sleepNSeconds(5);
           }
        });

        Thread other = new Thread(() -> {
            synchronized (obj) {
                System.out.println("先获取 obj 监视锁");
                while (true) {
                    int a = RandomUtils.nextInt();
                    if (a == 100) {
                        break;
                    }
                }
            }
        });

        other.start();
        SleepUtils.sleepNSeconds(1);

        one.start();
        SleepUtils.sleepNSeconds(1);
        Assert.assertEquals(Thread.State.BLOCKED, one.getState());
    }

    @Test
    public void testStateWaiting() {
        Lock lock = new ReentrantLock();
        lock.lock();
        Thread threadOne = new Thread(lock::lock);

        threadOne.start();
        SleepUtils.sleepNSeconds(1);
        Assert.assertEquals(Thread.State.WAITING, threadOne.getState());
    }

    @Test
    public void testStateTimedWaiting() {
        Thread thread = new Thread(() -> SleepUtils.sleepNSeconds(5));

        thread.start();
        Assert.assertEquals(Thread.State.RUNNABLE, thread.getState());
        SleepUtils.sleepNSeconds(1);
        Assert.assertEquals(Thread.State.TIMED_WAITING, thread.getState());
    }

    @Test
    public void testStateTerminated() {
        Thread thread = new Thread(() -> System.out.print("Hello Thread state!"));
        thread.start();
        SleepUtils.sleepNSeconds(3);
        Assert.assertEquals(Thread.State.TERMINATED, thread.getState());
    }
}

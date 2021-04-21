package fx.leyu.leetcode.thread.problem1115;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fxleyu
 */
public class FooBar {
    private final int n;
    private final AtomicInteger index = new AtomicInteger(0);
    private final Object lock = new Object();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while(index.get() % 2 != 0) {
                    lock.notifyAll();
                    lock.wait();
                }
                printFoo.run();
                index.incrementAndGet();
                lock.notifyAll();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while(index.get() % 2 != 1) {
                    lock.notifyAll();
                    lock.wait();
                }
                printBar.run();
                index.incrementAndGet();
                lock.notifyAll();
            }
        }
    }
}

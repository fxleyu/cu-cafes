package fx.leyu.leetcode.thread.problem1116;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author fxleyu
 */
public class ZeroEvenOdd {
    private final int n;
    private final Object lock = new Object();
    private final AtomicInteger index = new AtomicInteger(0);
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (index.get() % 2 != 0) {
                    lock.notifyAll();
                    lock.wait();
                }
                printNumber.accept(0);
                index.incrementAndGet();
                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int max = n / 2;
        for (int i = 1; i <= max; i++) {
            synchronized (lock) {
                while (index.get() % 2 != 1 || (index.get() / 2) % 2 != 1) {
                    lock.notifyAll();
                    lock.wait();
                }
                printNumber.accept(i * 2);
                index.incrementAndGet();
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int max = n / 2 + n % 2;
        for (int i = 0; i < max; i++) {
            synchronized (lock) {
                while (index.get() % 2 != 1 || index.get() / 2 % 2 == 1) {
                    lock.notifyAll();
                    lock.wait();
                }
                printNumber.accept(2 * i + 1);
                index.incrementAndGet();
                lock.notifyAll();
            }
        }
    }
}

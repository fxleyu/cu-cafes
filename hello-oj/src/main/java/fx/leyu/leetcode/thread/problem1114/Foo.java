package fx.leyu.leetcode.thread.problem1114;

import java.util.concurrent.atomic.AtomicInteger;

public class Foo {
    final AtomicInteger index = new AtomicInteger(0);
    final Object lock = new Object();
    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            while (index.get() % 3 != 0) {
                lock.wait();
            }
            printFirst.run();
            index.incrementAndGet();
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (index.get() % 3 != 1) {
                lock.wait();
            }
            printSecond.run();
            index.incrementAndGet();
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (index.get() % 3 != 2) {
                lock.wait();
            }
            printThird.run();
            index.incrementAndGet();
            lock.notifyAll();
        }
    }
}
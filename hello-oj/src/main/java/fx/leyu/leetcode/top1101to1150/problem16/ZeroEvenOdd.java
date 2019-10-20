package fx.leyu.leetcode.top1101to1150.problem16;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ZeroEvenOdd {
    private int n;
    private AtomicInteger index = new AtomicInteger(1);
    private Semaphore zeroSemaphore = new Semaphore(1);
    private Semaphore evenSemaphore = new Semaphore(0);
    private Semaphore oddSemaphore = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        if (n < 0) {
            return;
        }

        while (true) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            boolean shouldReturn = false;
            if (index.get() + 1 > n) {
                shouldReturn = true;
            }
            if (index.get() % 2 == 0) {
                evenSemaphore.release();
            } else {
                oddSemaphore.release();
            }
            if (shouldReturn) {
                return;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        if (n < 2) {
            return;
        }
        while (true) {
            evenSemaphore.acquire();
            printNumber.accept(index.get());
            boolean shouldReturn = false;
            if (index.get() + 2 > n) {
                shouldReturn = true;
            }
            if (index.getAndIncrement() < n) {
                zeroSemaphore.release();
            }
            if (shouldReturn) {
                return;
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            oddSemaphore.acquire();
            printNumber.accept(index.get());
            boolean shouldReturn = false;
            if (index.get() + 2 > n) {
                shouldReturn = true;
            }
            if (index.getAndIncrement() < n) {
                zeroSemaphore.release();
            }
            if (shouldReturn) {
                return;
            }
        }
    }
}

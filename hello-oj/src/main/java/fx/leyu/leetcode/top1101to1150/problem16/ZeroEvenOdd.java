package fx.leyu.leetcode.top1101to1150.problem16;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ZeroEvenOdd {
    private final int n;
    private final AtomicInteger index = new AtomicInteger(1);
    private final Semaphore zeroSemaphore = new Semaphore(1);
    private final Semaphore evenSemaphore = new Semaphore(0);
    private final Semaphore oddSemaphore = new Semaphore(0);

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
            boolean shouldReturn = index.get() + 1 > n;
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
            boolean shouldReturn = index.get() + 2 > n;
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
            boolean shouldReturn = index.get() + 2 > n;
            if (index.getAndIncrement() < n) {
                zeroSemaphore.release();
            }
            if (shouldReturn) {
                return;
            }
        }
    }
}

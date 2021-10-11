package fx.leyu.leetcode.thread.problem1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd1 {
    private final int n;
    private final Semaphore semaphore4Zero = new Semaphore(1);
    private final Semaphore semaphore4Odd = new Semaphore(0);
    private final Semaphore semaphore4even = new Semaphore(0);
    public ZeroEvenOdd1(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphore4Zero.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                semaphore4Odd.release();
            } else {
                semaphore4even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int max = n / 2;
        for (int i = 1; i <= max; i++) {
            semaphore4even.acquire();
            printNumber.accept(i * 2);
            semaphore4Zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int max = n / 2 + n % 2;
        for (int i = 0; i < max; i++) {
            semaphore4Odd.acquire();
            printNumber.accept(i * 2 + 1);
            semaphore4Zero.release();
        }
    }
}

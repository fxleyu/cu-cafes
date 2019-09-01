package fx.leyu.leetcode.top1101to1150.problem14;

public class Foo {
    private final Object LOCK = new Object();
    private volatile int flag = 1;
    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (LOCK) {
            while (flag != 1) {
                LOCK.wait();
            }

            printFirst.run();
            flag++;
            LOCK.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (LOCK) {
            while (flag != 2) {
                LOCK.wait();
            }

            printSecond.run();
            flag++;
            LOCK.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (LOCK) {
            while (flag != 3) {
                LOCK.wait();
            }

            printThird.run();
            flag++;
            LOCK.notifyAll();
        }
    }
}

package fx.leyu.leetcode.top1101to1150.problem15;

import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphoreA.acquire();
            printFoo.run();
            semaphoreB.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphoreB.acquire();
            printBar.run();
            semaphoreA.release();
        }
    }
}
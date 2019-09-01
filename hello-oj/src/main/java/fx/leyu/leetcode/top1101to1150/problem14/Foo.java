package fx.leyu.leetcode.top1101to1150.problem14;

public class Foo {
    private final static Object TWO = new Object();
    private final static Object THREE = new Object();

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        synchronized (TWO) {
            TWO.notify();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (TWO) {
            TWO.wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        synchronized (THREE) {
            THREE.notify();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (THREE) {
            THREE.wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

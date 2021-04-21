package fx.leyu.jdk.lang.reflect;

import java.util.concurrent.atomic.AtomicInteger;

public class XYZDemo {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger index = new AtomicInteger(0);
        Object lock = new Object();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    int x;
                    while ((x = index.get() % 3) != 0) {
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("X");
                    index.incrementAndGet();
                    lock.notifyAll();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    int x;
                    while ((x = index.get() % 3) != 1) {
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("Y");
                    index.incrementAndGet();
                    lock.notifyAll();

                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    int x;
                    while ((x = index.get() % 3) != 2) {
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("Z");
                    index.incrementAndGet();
                    lock.notifyAll();
                }
            }
        }).start();
    }
}

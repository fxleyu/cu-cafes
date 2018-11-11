package fx.leyu.jdk.util.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HelloCondition {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        final Condition conditionA = lock.newCondition();
        final Condition conditionB = lock.newCondition();
        new Thread(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            work(lock, conditionA, conditionB, true);
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            work(lock, conditionB, conditionA, false);
        }).start();
    }

    private static void work(Lock lock, Condition first, Condition second, boolean isFirst) {
        int i = isFirst ? 0 : 1;
        lock.lock();
        try {
            if (!isFirst) {
                second.signal();
            }
            while (true) {
                first.await();
                System.out.println((isFirst ? "0 ->" : "1 ->") + i);
                i += 2;
                second.signal();
                if (i > 10) {
                    break;
                }
            }
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}

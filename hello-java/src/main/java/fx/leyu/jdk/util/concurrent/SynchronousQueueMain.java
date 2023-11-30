package fx.leyu.jdk.util.concurrent;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueMain {
    private static final int MAX = 100;

    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                for (int i = 0; i < MAX; i++) {
                    System.out.println("A: " + synchronousQueue.take());
                    TimeUnit.MILLISECONDS.sleep(20);
                    System.out.println("A: take " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < MAX; i++) {
                    // 将指定元素添加到此队列，等待另一个线程接收它
                    System.out.println("B: " + i + " " + synchronousQueue.offer("Test " + i));
                    TimeUnit.MILLISECONDS.sleep(10);
                    System.out.println("B: put " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

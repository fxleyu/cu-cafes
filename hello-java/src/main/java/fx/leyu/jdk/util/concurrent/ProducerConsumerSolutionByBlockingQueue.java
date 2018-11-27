package fx.leyu.jdk.util.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerSolutionByBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(2);
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < 15; i++)
            new Thread(() -> {
                while (true)
                    try {
                        queue.put("production NO. " + count.getAndIncrement());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }).start();
        for (int i = 0; i < 6; i++)
            new Thread(() -> {
                while (true)
                    try {
                        System.out.println(queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }).start();

    }
}

package fx.leyu.jdk.lang;

import org.apache.commons.lang3.RandomUtils;

public class ThreadDemo {

    public static void handleRunnable() {
        Runnable runnable = () -> System.out.print("Hello world!");
        new Thread(runnable).start();
    }

    public static void handleThreadState() {
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable a = () -> {
                while (true) {
                    int x = RandomUtils.nextInt(0, 100000000);
                    if (x % 100 == 0) {
                        if (x == 6000) {
                            try {
                                System.out.println("a rr sleep before");
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        };

        Thread.currentThread().interrupt();
        Thread t = new Thread(a);
        t.start();
        System.out.println("sleep before");
        Thread.sleep(50);
        System.out.println("sleep end");
        t.interrupt();
    }
}

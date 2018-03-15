package fx.leyu.effective.concurrent;

import java.util.concurrent.TimeUnit;

public class StopThreadForVolatile {
    private static volatile boolean stopRequest;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequest) {
                    i++;
                }
                System.out.println("线程运行结束 i= " + i);
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);

        // 期待程序终止
        stopRequest = true;

        System.out.println("Game Over!");
    }
}

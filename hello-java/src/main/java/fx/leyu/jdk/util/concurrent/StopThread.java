package fx.leyu.jdk.util.concurrent;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static boolean stopRequest;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequest) {
                    i++;
                }
                /* 与上述代码块等同
                if (!stopRequest) {
                    while(true) {
                        i++
                    }
                }
                */
                System.out.println("线程运行结束 i= " + i);
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);

        // 期待程序终止
        stopRequest = true;

        // 结果为:程序一直运行
        /*
         * 结果：程序一直运行
         * 原因为由于VM优化提升（hositing），导致活性失败（liveness failure）
         */
        System.out.println("Game Over!");
    }
}

package fx.leyu.effective.concurrent;

import java.util.concurrent.TimeUnit;

public class StopThreadForSync {
    private static boolean stopRequest;
    
    private static synchronized void requestStop() {
        stopRequest = true;
        
    }

    private static synchronized boolean stopRequested() {
        return stopRequest;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested()) {
                    i++;
                }
                System.out.println("线程运行结束 i= " + i);
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);

        // 期待程序终止
        requestStop();
        
        System.out.println("Game Over!");
    }
}

package fx.leyu.zk.seckill;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

public class SecKillMain {
    private static int WIKI = 10;
    public static void main(String[] args) {
        // 重试的策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("192.168.213.129:2181")
                .retryPolicy(retryPolicy)
                .build();
        client.start();

        final InterProcessMutex lock = new InterProcessMutex(client,"/sec_kill_lock");
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    lock.acquire();
                    secKillSku();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        lock.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }).start();
        }
    }

    private static void secKillSku() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WIKI--;
        System.out.println(WIKI);
    }
}

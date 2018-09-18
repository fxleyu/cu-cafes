package fx.leyu.zk.test;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class FirstZKWatcher implements Watcher {
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.199.120:2181", 5000, new FirstZKWatcher());
        System.out.println(zooKeeper.getState());

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ZK established");
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("process start " + watchedEvent);
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            latch.countDown();
        }
    }
}

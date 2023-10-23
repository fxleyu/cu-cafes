package fx.leyu.jdk.util.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerLockUtils {
    
    public static int num = 0;
    private static final int MAX = 6;
    private static final Lock producerConsumerLock = new ReentrantLock();
    
    public synchronized void acquireProducerLock(){
        while (num >= MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        producerConsumerLock.lock();
    }
    
    public synchronized void releaseProducerLock(){
        num++;
        this.notify();
        producerConsumerLock.unlock();
    }
    
    public synchronized void acquireConsumerLock(){
        while (num < 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        producerConsumerLock.lock();
    }
    
    public synchronized void releaseConsumerLock(){
        num--;
        this.notify();
        producerConsumerLock.unlock();
    }
}

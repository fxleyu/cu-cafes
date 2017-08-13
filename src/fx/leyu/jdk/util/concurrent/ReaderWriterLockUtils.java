package fx.leyu.jdk.util.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReaderWriterLockUtils {

    private int readerNum = 0;
    private static Lock readerWriterLock = new ReentrantLock();

    public synchronized void acquireReaderLock() {
        while (readerNum == 0) {
            readerWriterLock.lock();
        }
        readerNum++;
    }

    public synchronized void releaseReaderLock() {
        readerNum--;
        while (readerNum == 0) {
            readerWriterLock.unlock();
        }
        this.notify();
    }

    public synchronized void acquireWriterLock() {
        while (readerNum > 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        readerWriterLock.lock();
    }

    public synchronized void releaseWriterLock() {
        this.notifyAll();
        readerWriterLock.unlock();
    }
}

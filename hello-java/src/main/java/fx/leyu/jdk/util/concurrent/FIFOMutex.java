package fx.leyu.jdk.util.concurrent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @author fxleyu
 */
public class FIFOMutex {
    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final Queue<Thread> waiters
            = new ConcurrentLinkedQueue<Thread>();

    public void lock() {
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        waiters.add(current);

        // Block while not first in queue or cannot acquire lock
        while (waiters.peek() != current ||
                !locked.compareAndSet(false, true)) {
            LockSupport.park(this);
            // ignore interrupts while waiting
            if (Thread.interrupted()) {
                wasInterrupted = true;
            }
        }

        waiters.remove();
        if (wasInterrupted) {
            // reassert interrupt status on exit
            current.interrupt();
        }
    }

    public void unlock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }
}

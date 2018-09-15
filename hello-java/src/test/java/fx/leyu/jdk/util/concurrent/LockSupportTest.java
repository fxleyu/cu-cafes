package fx.leyu.jdk.util.concurrent;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    @Test
    public void testThePermitIsAvailable() {
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        Assert.assertTrue(true);
    }

    @Test(timeout = 100)
    @Ignore("应该永远阻塞的")
    public void testThePermitIsNotAvailable() {
        LockSupport.park();
    }
}

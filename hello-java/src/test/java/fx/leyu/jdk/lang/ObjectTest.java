package fx.leyu.jdk.lang;

import org.junit.Assert;
import org.junit.Test;

public class ObjectTest {
    @Test
    public void testGetClass() {
        Object obj = new Object();
        Assert.assertEquals(Object.class, obj.getClass());
    }

    @Test
    public void testEquals() {
        Object obj = new Object();
        Assert.assertNotEquals(null, obj);
    }

    @Test
    public void testHashCode() {
        Object obj = new Object();
        Assert.assertEquals(369241501, obj.hashCode());
    }

    @Test
    public void testToString() {
        Object obj = new Object();
        Assert.assertEquals("java.lang.Object@281e3708", obj.toString());
    }

    @Test
    public void testWaiting() {
        Object obj = new Object();
        synchronized (obj) {
            try {
                obj.wait(222);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Assert.assertTrue(true);
    }

    @Test
    public void testNotify() {
        final Object obj = new Object();
        synchronized (obj) {
            obj.notify();
        }
        Assert.assertNull(null);
    }
}

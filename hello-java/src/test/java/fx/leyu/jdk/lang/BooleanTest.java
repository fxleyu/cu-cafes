package fx.leyu.jdk.lang;

import org.junit.Assert;
import org.junit.Test;

public class BooleanTest {
    @Test
    public void testEqual() {
        Assert.assertTrue(!Boolean.TRUE.equals(null));
        Assert.assertTrue(!Boolean.TRUE.equals(false));
        Assert.assertTrue(Boolean.TRUE.equals(true));
    }
}

package fx.leyu.jdk.lang;

import org.junit.Assert;
import org.junit.Test;

public class BooleanTest {
    @Test
    public void testEqual() {
        Assert.assertFalse(Boolean.TRUE.equals(null));
        Assert.assertFalse(Boolean.TRUE.equals(false));
        Assert.assertTrue(Boolean.TRUE.equals(true));
    }
}

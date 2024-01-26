package fx.leyu.jdk.lang;

import org.junit.Assert;
import org.junit.Test;

public class BooleanTest {
    @Test
    public void testEqual() {
        Assert.assertNotEquals(false, (boolean) Boolean.TRUE);
        Assert.assertTrue((boolean) Boolean.TRUE);
    }
}

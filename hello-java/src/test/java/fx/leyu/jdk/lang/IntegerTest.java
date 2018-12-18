package fx.leyu.jdk.lang;

import org.junit.Assert;
import org.junit.Test;

public class IntegerTest {

    @Test
    public void testMinValue() {
        Assert.assertTrue(Integer.MIN_VALUE == -Integer.MIN_VALUE);
    }
}

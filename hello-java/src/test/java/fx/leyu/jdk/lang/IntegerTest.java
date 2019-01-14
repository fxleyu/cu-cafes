package fx.leyu.jdk.lang;

import org.junit.Assert;
import org.junit.Test;

public class IntegerTest {

    @Test
    public void testMinValue() {
        Assert.assertTrue(Integer.MIN_VALUE == -Integer.MIN_VALUE);
    }

    @Test
    public void testBitOperation() {
        String string = Integer.toString(Integer.MAX_VALUE, 2);
        int value = Integer.valueOf("-" + string, 2);
        Assert.assertTrue(value - 1 == Integer.MIN_VALUE);
    }

    @Test(expected = NumberFormatException.class)
    public void test32One() {
        String string = Integer.toString(Integer.MAX_VALUE, 2); // 31 个 1
        int value = Integer.valueOf("1" + string, 2);
    }
}

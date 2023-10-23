package fx.leyu.jdk.lang;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;

public class IntegerTest {

    @Test
    public void testMinValue() {
        Assert.assertEquals(Integer.MIN_VALUE, -Integer.MIN_VALUE);
    }

    @Test
    public void testBitOperation() {
        String string = Integer.toString(Integer.MAX_VALUE, 2);
        int value = Integer.valueOf("-" + string, 2);
        Assert.assertEquals(Integer.MIN_VALUE, value - 1);
    }

    @Test(expected = NumberFormatException.class)
    public void test32One() {
        String string = Integer.toString(Integer.MAX_VALUE, 2); // 31 个 1
        int value = Integer.valueOf("1" + string, 2);
    }

    public static class ArrayTest {
        @Test
        public void testGetLength() {
            String[] stringArray = {};
            Assert.assertEquals(0, Array.getLength(stringArray));

            int[] intArray = {1, 2};
            Assert.assertEquals(2, Array.getLength(intArray));

            Assert.assertEquals(0, ArrayUtils.getLength(null));
        }
    }
}

package fx.leyu.jdk.lang.reflect;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;

public class ArrayTest {
    @Test
    public void testGetLength() {
        String[] stringArray = {};
        Assert.assertEquals(0, Array.getLength(stringArray));

        int[] intArray = {1, 2};
        Assert.assertEquals(2, Array.getLength(intArray));

        intArray = null;
        Assert.assertEquals(0, ArrayUtils.getLength(intArray));
    }
}

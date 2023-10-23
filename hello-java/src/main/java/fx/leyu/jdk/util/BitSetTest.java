package fx.leyu.jdk.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.BitSet;

/**
 * @author fxleyu
 */
public class BitSetTest {

    @Test
    public void test() {
        BitSet bitSet = new BitSet();
        Assert.assertFalse(bitSet.get(1));
        bitSet.set(2);
        Assert.assertFalse(bitSet.get(1));
        Assert.assertTrue(bitSet.get(2));
    }
}

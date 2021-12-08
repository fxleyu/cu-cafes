package fx.leyu.jdk.lang;

import org.junit.Assert;
import org.junit.Test;

public class BitOperationTest {
    @Test
    public void testAndOperation() {
        Assert.assertEquals(1, 1 & 1);
        Assert.assertEquals(0, 0 & 1);
        Assert.assertEquals(0, 0 & 2);
        Assert.assertEquals(0, 0 & 3);
        Assert.assertEquals(0, 0 & 4);

        int mode = 3;
        mode &= ~2;
        System.out.println(mode);

        Assert.assertEquals(0, (0 >> 1) & 1);
        Assert.assertEquals(0, (1 >> 1) & 1);
        Assert.assertEquals(1, (2 >> 1) & 1);
        Assert.assertEquals(1, (3 >> 1) & 1);
    }


}

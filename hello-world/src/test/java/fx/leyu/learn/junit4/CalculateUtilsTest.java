package fx.leyu.learn.junit4;

import org.junit.Assert;
import org.junit.Test;

public class CalculateUtilsTest {

    @Test
    public void testAdd() {
        Assert.assertEquals("Add error", 4, CalculateUtils.add(3, 1));
    }

    @Test
    public void testSub() {
        Assert.assertEquals("Sub error", 2, CalculateUtils.sub(3, 1));
    }

    @Test
    public void testMult() {
        Assert.assertEquals("Mult error", 6, CalculateUtils.mult(3, 2));
    }

    @Test
    public void testDiv() {
        Assert.assertEquals("div error", 3, CalculateUtils.div(3, 1));
    }

}

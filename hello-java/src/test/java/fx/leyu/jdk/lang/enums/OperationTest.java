package fx.leyu.jdk.lang.enums;

import org.junit.Assert;
import org.junit.Test;

public class OperationTest {
    private static final long X = 200;
    private static final long Y = 100;

    @Test
    public void testPlus() {
        Assert.assertEquals(X + Y, Operation.PLUS.apply(X, Y));
    }

    @Test
    public void testMinus() {
        Assert.assertEquals(X - Y, Operation.MINUS.apply(X, Y));
    }

    @Test
    public void testTimes() {
        Assert.assertEquals(X * Y, Operation.TIMES.apply(X, Y));
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(X / Y, Operation.DIVIDE.apply(X, Y));
    }

    @Test
    public void testValueOf() {
        Operation operation = Operation.valueOf("PLUS");
        Assert.assertEquals(X + Y, operation.apply(X, Y));
        Assert.assertEquals(X + Y, operation);
    }
}

package fx.leyu.jdk.math;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {
    @Test
    public void test() {
        Assert.assertEquals("100000000000000000000001.000000001",
                new BigDecimal("100000000000000000000001.000000001").toPlainString());

        Assert.assertEquals("-1.0000000000000000000000000000000000000",
                new BigDecimal("-1.0000000000000000000000000000000000000").toString());

        Assert.assertEquals("-1",
                new BigDecimal("-1.0000000000000000000000000000000000000").stripTrailingZeros().toString());

        Assert.assertEquals("-10E-24",
                new BigDecimal("-0.00000000000000000000001").toEngineeringString());
    }

    @Test
    public void testDivide() {
        BigDecimal a = new BigDecimal("1.00");
        BigDecimal b = new BigDecimal("3.00");

        Assert.assertEquals("0.33", a.divide(b, RoundingMode.HALF_UP).toPlainString());

        Assert.assertEquals("0.3", a.divide(b, 1, RoundingMode.HALF_UP).toPlainString());
        Assert.assertEquals("0.33", a.divide(b, 2, RoundingMode.HALF_UP).toPlainString());
        Assert.assertEquals("0.333", a.divide(b, 3, RoundingMode.HALF_UP).toPlainString());
    }

    @Test
    public void testEquals() {
        BigDecimal zero = new BigDecimal("0");
        Assert.assertEquals(0, zero.scale());
        Assert.assertEquals(BigDecimal.ZERO, zero);

        zero = new BigDecimal("0.00");
        BigDecimal systemZero = BigDecimal.ZERO;
        Assert.assertEquals(2, zero.scale());
        Assert.assertFalse(systemZero.equals(zero));
    }
}

package fx.leyu.jdk.math;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

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
}

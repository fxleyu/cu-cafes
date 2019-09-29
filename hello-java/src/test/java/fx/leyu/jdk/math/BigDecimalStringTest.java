package fx.leyu.jdk.math;

import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalStringTest {
    @Test
    public void test() {
        System.out.println(new BigDecimal("100000000000000000000001.000000001").toPlainString());
        System.out.println(new BigDecimal("100000000000000000000001.000000001").toString());
        System.out.println(new BigDecimal("-1000000000000000000000000000000000000000000000000000000000000000000000").toEngineeringString());
    }
}

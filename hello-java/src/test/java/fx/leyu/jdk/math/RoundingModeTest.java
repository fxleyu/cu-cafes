package fx.leyu.jdk.math;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundingModeTest {
    private static final int ZERO_SCALE = 0;

    /**
     * UP 基准是 0
     */
    @Test
    public void testUp() {
        Assert.assertEquals("2", new BigDecimal("1.5").setScale(ZERO_SCALE, RoundingMode.UP).toString());
        Assert.assertEquals("2", new BigDecimal("1.4").setScale(ZERO_SCALE, RoundingMode.UP).toString());
        Assert.assertEquals("-2", new BigDecimal("-1.4").setScale(ZERO_SCALE, RoundingMode.UP).toString());
        Assert.assertEquals("-2", new BigDecimal("-1.5").setScale(ZERO_SCALE, RoundingMode.UP).toString());
    }

    /**
     * DOWN 基准是 0
     */
    @Test
    public void testDown() {
        Assert.assertEquals("1", new BigDecimal("1.5").setScale(ZERO_SCALE, RoundingMode.DOWN).toString());
        Assert.assertEquals("1", new BigDecimal("1.4").setScale(ZERO_SCALE, RoundingMode.DOWN).toString());
        Assert.assertEquals("-1", new BigDecimal("-1.4").setScale(ZERO_SCALE, RoundingMode.DOWN).toString());
        Assert.assertEquals("-1", new BigDecimal("-1.5").setScale(ZERO_SCALE, RoundingMode.DOWN).toString());
    }

    /**
     * CEILING 基准是无穷
     */
    @Test
    public void testCeiling() {
        Assert.assertEquals("2", new BigDecimal("1.5").setScale(ZERO_SCALE, RoundingMode.CEILING).toString());
        Assert.assertEquals("2", new BigDecimal("1.4").setScale(ZERO_SCALE, RoundingMode.CEILING).toString());
        Assert.assertEquals("-1", new BigDecimal("-1.4").setScale(ZERO_SCALE, RoundingMode.CEILING).toString());
        Assert.assertEquals("-1", new BigDecimal("-1.5").setScale(ZERO_SCALE, RoundingMode.CEILING).toString());
    }

    /**
     * FLOOR 基准是无穷
     */
    @Test
    public void testFloor() {
        Assert.assertEquals("1", new BigDecimal("1.5").setScale(ZERO_SCALE, RoundingMode.FLOOR).toString());
        Assert.assertEquals("1", new BigDecimal("1.4").setScale(ZERO_SCALE, RoundingMode.FLOOR).toString());
        Assert.assertEquals("-2", new BigDecimal("-1.4").setScale(ZERO_SCALE, RoundingMode.FLOOR).toString());
        Assert.assertEquals("-2", new BigDecimal("-1.5").setScale(ZERO_SCALE, RoundingMode.FLOOR).toString());
    }

    /**
     * HALF_UP 基准是四舍五入（基准是 0）
     */
    @Test
    public void testHalfUp() {
        Assert.assertEquals("2", new BigDecimal("1.5").setScale(ZERO_SCALE, RoundingMode.HALF_UP).toString());
        Assert.assertEquals("1", new BigDecimal("1.4").setScale(ZERO_SCALE, RoundingMode.HALF_UP).toString());
        Assert.assertEquals("-1", new BigDecimal("-1.4").setScale(ZERO_SCALE, RoundingMode.HALF_UP).toString());
        Assert.assertEquals("-2", new BigDecimal("-1.5").setScale(ZERO_SCALE, RoundingMode.HALF_UP).toString());
    }

    /**
     * HALF_DOWN 基准是五舍六入（基准是 0）
     */
    @Test
    public void testHalfDown() {
        Assert.assertEquals("1", new BigDecimal("1.5").setScale(ZERO_SCALE, RoundingMode.HALF_DOWN).toString());
        Assert.assertEquals("2", new BigDecimal("1.6").setScale(ZERO_SCALE, RoundingMode.HALF_DOWN).toString());
        Assert.assertEquals("-1", new BigDecimal("-1.5").setScale(ZERO_SCALE, RoundingMode.HALF_DOWN).toString());
        Assert.assertEquals("-2", new BigDecimal("-1.6").setScale(ZERO_SCALE, RoundingMode.HALF_DOWN).toString());
    }

}

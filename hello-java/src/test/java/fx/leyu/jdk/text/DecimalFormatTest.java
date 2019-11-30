package fx.leyu.jdk.text;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 数字格式化
 *
 * @author fxleyu
 */
public class DecimalFormatTest {
    @Test
    public void testFormat() {
        Assert.assertEquals(".0120", new DecimalFormat(".0000").format(new BigDecimal("0.012001")));
        Assert.assertEquals(".012", new DecimalFormat(".####").format(new BigDecimal("0.01200001")));
        Assert.assertEquals("0.0120", new DecimalFormat("0.0000").format(new BigDecimal("0.01200001")));
        Assert.assertEquals("0.012", new DecimalFormat("#.####").format(new BigDecimal("0.01201")));
        Assert.assertEquals("010.0120", new DecimalFormat("000.0000").format(new BigDecimal("10.01200001")));
        Assert.assertEquals("10.012", new DecimalFormat("###.####").format(new BigDecimal("10.01200001")));
    }
}

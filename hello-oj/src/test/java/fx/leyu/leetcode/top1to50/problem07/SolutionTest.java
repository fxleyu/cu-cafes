package fx.leyu.leetcode.top1to50.problem07;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Assert.assertEquals(321, new Solution().reverse(123));
        Assert.assertEquals(-321, new Solution().reverse(-123));
        Assert.assertEquals(0, new Solution().reverse(Integer.MAX_VALUE));
        Assert.assertEquals(0, new Solution().reverse(Integer.MIN_VALUE));
    }
}

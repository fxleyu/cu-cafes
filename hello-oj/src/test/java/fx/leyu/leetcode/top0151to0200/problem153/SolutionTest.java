package fx.leyu.leetcode.top0151to0200.problem153;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Assert.assertEquals(1, new Solution().findMin(new int[]{3, 4, 5, 1, 2}));
        Assert.assertEquals(0, new Solution().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        Assert.assertEquals(1, new Solution().findMin(new int[]{2, 1}));
    }
}

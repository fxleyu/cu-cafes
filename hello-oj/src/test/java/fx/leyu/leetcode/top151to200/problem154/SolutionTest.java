package fx.leyu.leetcode.top151to200.problem154;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Assert.assertEquals(1, new Solution().findMin(new int[]{1, 3, 5}));
        Assert.assertEquals(0, new Solution().findMin(new int[]{2, 2, 2, 0, 1}));
    }
}

package fx.leyu.leetcode.top1to50.problem35;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Assert.assertEquals(2, new Solution().searchInsert(new int[]{1,3,5,6}, 5));
        Assert.assertEquals(1, new Solution().searchInsert(new int[]{1,3,5,6}, 2));
        Assert.assertEquals(4, new Solution().searchInsert(new int[]{1,3,5,6}, 7));
        Assert.assertEquals(0, new Solution().searchInsert(new int[]{1,3,5,6}, 0));
    }

    @Test
    public void testError1() {
        Assert.assertEquals(0, new Solution().searchInsert(new int[]{1,3}, 0));
    }

    @Test
    public void testError2() {
        Assert.assertEquals(0, new Solution().searchInsert(new int[]{1}, 1));
    }
}

package fx.leyu.leetcode.top0001to0050.problem04;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        double delta = 0.001;
        Solution solution = new Solution();
        Assert.assertEquals(2.0, solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), delta);
        Assert.assertEquals(2.5, solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), delta);
    }
}

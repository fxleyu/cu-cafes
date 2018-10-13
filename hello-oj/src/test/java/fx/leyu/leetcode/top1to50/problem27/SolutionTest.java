package fx.leyu.leetcode.top1to50.problem27;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        int[] arr = {3, 2, 2, 3};
        int x = new Solution().removeElement(arr, 3);
        Assert.assertEquals(2, x);
        Assert.assertEquals(2, arr[0]);
        Assert.assertEquals(2, arr[1]);
    }
}

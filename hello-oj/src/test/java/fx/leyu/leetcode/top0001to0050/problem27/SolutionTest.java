package fx.leyu.leetcode.top0001to0050.problem27;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        int[] arr = {3, 2, 2, 3};
        int x = new Solution().removeElement(arr, 3);
        Assert.assertEquals(2, x);
        Assert.assertEquals(0, new Solution().removeElement(new int[]{3,3,3,3}, 3));

        Assert.assertEquals(4, new Solution().removeElement(new int[]{4,5,5,6}, 3));

        Assert.assertEquals(4, new Solution().removeElement(new int[]{4,5,5,6}, 3));

        Assert.assertEquals(1, new Solution().removeElement(new int[]{4,3}, 3));

        Assert.assertEquals(1, new Solution().removeElement(new int[]{3,4}, 3));
    }
}

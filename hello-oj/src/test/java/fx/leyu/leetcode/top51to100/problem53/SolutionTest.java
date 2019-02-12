package fx.leyu.leetcode.top51to100.problem53;

import fx.leyu.leetcode.top50to100.problem53.Solution;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SolutionTest {
    private static Solution solution;

    @BeforeClass
    public static void initStatic() {
        solution = new Solution();
    }

    @Test
    public void testMaxSubArray() {
        Assert.assertEquals(6, solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void testError01() {
        Assert.assertEquals(0, solution.maxSubArray(new int[] {-1,0,-2}));
        /*
        -1, -1, 0
         */
    }
}

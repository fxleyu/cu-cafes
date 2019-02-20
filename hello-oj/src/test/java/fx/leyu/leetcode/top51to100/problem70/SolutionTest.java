package fx.leyu.leetcode.top51to100.problem70;

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
    public void testClimbStairs() {
        Assert.assertEquals(1, solution.climbStairs(1));
        Assert.assertEquals(2, solution.climbStairs(2));
        Assert.assertEquals(3, solution.climbStairs(3));
    }
}

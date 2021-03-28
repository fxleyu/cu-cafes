package fx.leyu.leetcode.top0051to0100.problem62;

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
    public void testLengthOfLastWord() {
        Assert.assertEquals(28, solution.uniquePaths(3, 7));
        Assert.assertEquals(3, solution.uniquePaths(3, 2));
        Assert.assertEquals(28, solution.uniquePaths(7, 3));
        Assert.assertEquals(6, solution.uniquePaths(3, 3));
    }
}


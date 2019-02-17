package fx.leyu.leetcode.top51to100.problem67;

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
    public void testAddBinary() {
        Assert.assertEquals("100", solution.addBinary("1", "11"));
        Assert.assertEquals("10101", solution.addBinary("1010", "1011"));
    }

}

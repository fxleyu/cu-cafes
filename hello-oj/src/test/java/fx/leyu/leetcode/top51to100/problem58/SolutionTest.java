package fx.leyu.leetcode.top51to100.problem58;

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
        Assert.assertEquals(5, solution.lengthOfLastWord("Hello World"));
        Assert.assertEquals(6, solution.lengthOfLastWord("Hellos"));
    }
}

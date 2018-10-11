package fx.leyu.leetcode.top1to50.problem20;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Assert.assertTrue(new Solution().isValid("()"));
        Assert.assertTrue(new Solution().isValid("()[]{}"));
        Assert.assertTrue(new Solution().isValid("{[]}"));

        Assert.assertFalse(new Solution().isValid("([)]"));
        Assert.assertFalse(new Solution().isValid("[)"));
        Assert.assertFalse(new Solution().isValid("{[]"));
    }
}

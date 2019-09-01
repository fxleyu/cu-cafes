package fx.leyu.leetcode.top0001to0050.problem20;

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

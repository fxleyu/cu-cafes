package fx.leyu.leetcode.top1to50.problem09;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Assert.assertTrue(new Solution().isPalindrome(121));
        Assert.assertFalse(new Solution().isPalindrome(-121));
        Assert.assertFalse(new Solution().isPalindrome(10));
    }
}

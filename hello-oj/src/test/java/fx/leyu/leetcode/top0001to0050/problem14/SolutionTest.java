package fx.leyu.leetcode.top0001to0050.problem14;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Assert.assertEquals("fl", new Solution().longestCommonPrefix(new String[]{"flower","flow","flight"}));
        Assert.assertEquals("", new Solution().longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}

package fx.leyu.leetcode.top1to50.problem03;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Assert.assertEquals(3, new Solution().lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, new Solution().lengthOfLongestSubstring("bbbbbb"));
        Assert.assertEquals(3, new Solution().lengthOfLongestSubstring("pwwkew"));
    }
}

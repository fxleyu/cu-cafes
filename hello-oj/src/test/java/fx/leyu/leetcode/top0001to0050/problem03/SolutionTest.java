package fx.leyu.leetcode.top0001to0050.problem03;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Assert.assertEquals(3, new Solution().lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, new Solution().lengthOfLongestSubstring("bbbbbb"));
        Assert.assertEquals(3, new Solution().lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(2, new Solution().lengthOfLongestSubstring("abba"));
    }
}

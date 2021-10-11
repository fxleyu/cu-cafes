package fx.leyu.leetcode.top0001to0050.problem28;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Assert.assertEquals(2, new Solution().strStr("hello", "ll"));
        Assert.assertEquals(-1, new Solution().strStr("aaaaaaa", "bba"));
        Assert.assertEquals(0, new Solution().strStr("", ""));
    }
}

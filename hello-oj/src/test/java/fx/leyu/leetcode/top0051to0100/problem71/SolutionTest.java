package fx.leyu.leetcode.top0051to0100.problem71;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Assert.assertEquals("/home", new Solution().simplifyPath("/home/"));
        Assert.assertEquals("/c", new Solution().simplifyPath("/a/./b/../../c/"));
        Assert.assertEquals("/c", new Solution().simplifyPath("/a/../../b/../c//.//"));
        Assert.assertEquals("/a/b/c", new Solution().simplifyPath("/a//b////c/d//././/.."));
    }
}

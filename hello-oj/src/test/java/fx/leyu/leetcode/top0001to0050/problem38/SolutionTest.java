package fx.leyu.leetcode.top0001to0050.problem38;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        for (int i = 0; i < 30; i++) {
            System.out.println(new Solution().countAndSay(i + 1));
        }
    }
}

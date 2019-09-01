package fx.leyu.leetcode.top0051to0100.problem88;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void test() {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        new Solution().merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }
}

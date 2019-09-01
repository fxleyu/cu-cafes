package fx.leyu.leetcode.top0001to0050.problem26;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int x = new Solution().removeDuplicates(arr);
        for (int i = 0; i < x; i++) {
            System.out.println(arr[i]);
        }
    }
}

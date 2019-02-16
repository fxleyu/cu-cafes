package fx.leyu.leetcode.top50to100.problem53;

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("The argument is null or empty!");
        }

        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int num : nums) {
            if (temp > 0) {
                temp += num;
            } else {
                temp = num;
            }
            max = Math.max(temp, max);
        }
        return max;
    }
}

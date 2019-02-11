package fx.leyu.leetcode.top50to100.problem53;

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("the argument is null");
        }
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int num : nums) {
            temp += num;
            if (temp >= num) {
                max = Math.max(max, temp);
            } else {
                temp = num;
            }
        }
        return Math.max(max, temp);
    }
}
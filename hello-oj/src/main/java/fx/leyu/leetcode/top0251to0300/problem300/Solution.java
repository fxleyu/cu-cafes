package fx.leyu.leetcode.top0251to0300.problem300;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("args can not null");
        }
        if (nums.length < 2) {
            return nums.length;
        }

        int[] value = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int tempMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    tempMax = Math.max(tempMax, value[j] + 1);
                }
            }
            value[i] = tempMax;
            max = Math.max(max, tempMax);
        }
        return max;
    }
}
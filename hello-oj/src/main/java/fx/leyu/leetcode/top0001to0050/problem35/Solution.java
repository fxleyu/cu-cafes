package fx.leyu.leetcode.top0001to0050.problem35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums.length - 1;
        int min = 0;
        while (max > min) {
            int index = (max + min) / 2;
            int value = nums[index];
            if (value > target) {
                max = index - 1;
            } else if (value < target) {
                min = index + 1;
            } else {
                return index;
            }
        }

        return nums[min] >= target ? min : min + 1;
    }
}

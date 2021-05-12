package fx.leyu.leetcode.top0001to0050.problem27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            while (nums[start] != val && start < end) {
                start++;
            }
            while (nums[end] == val && start < end) {
                end--;
            }
            if (start < end) {
                nums[start++] = nums[end];
                nums[end--] = val;
            }
        }
        return nums[start] == val ? start : start + 1;
    }
}

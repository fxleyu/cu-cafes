package fx.leyu.leetcode.top0700to0750.problem704;

import java.util.Objects;

class Solution {
    public int search(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start >= 0 && end < nums.length && start <= end) {
            int index = (start + end) / 2;
            if (nums[index] == target) {
                return index;
            }
            if (nums[index] < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
        return -1;
    }
}

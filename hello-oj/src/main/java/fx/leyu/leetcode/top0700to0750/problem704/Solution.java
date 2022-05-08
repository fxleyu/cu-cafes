package fx.leyu.leetcode.top0700to0750.problem704;

import java.util.Objects;

class Solution {
    public int search(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int index = (start + end) / 2;
            if (nums[index] == target) {
                return index;
            }
            if (nums[index] < target) {
                // next, [mid + 1, end]
                start = index + 1;
            } else {
                // next, [start, mid - 1]
                end = index - 1;
            }
        }
        return -1;
    }
}

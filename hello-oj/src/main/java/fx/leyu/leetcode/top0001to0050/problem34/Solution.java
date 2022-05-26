package fx.leyu.leetcode.top0001to0050.problem34;

import java.util.Objects;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return new int[] {-1, -1};
        }

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                int l = mid;
                int r = mid;
                while (l > 0 && nums[l - 1] == target) {
                    l = l - 1;
                }
                while (r < nums.length - 1 && nums[r + 1] == target) {
                    r = r + 1;
                }
                return new int[] {l, r};
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return new int[] {-1, -1};
    }
}
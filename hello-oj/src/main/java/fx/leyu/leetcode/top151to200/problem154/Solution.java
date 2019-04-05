package fx.leyu.leetcode.top151to200.problem154;

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("input cannot be null");
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right && nums[left] >= nums[right]) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left += 1;
            }
        }
        return nums[left];
    }
}

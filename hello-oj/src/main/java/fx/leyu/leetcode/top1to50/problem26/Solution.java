package fx.leyu.leetcode.top1to50.problem26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums == null || nums.length == 0 ? 0 : 1;
        }
        int result = 1;
        for (int next = 1; next < nums.length; next++) {
            if (nums[result - 1] == nums[next]) {
                continue;
            }
            if (next != result) {
                nums[result] = nums[next];
            }
            result++;
        }
        return result;
    }
}

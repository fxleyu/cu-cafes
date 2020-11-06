package fx.leyu.leetcode.top0151to0200.problem169;

/**
 * @author fxleyu
 */
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException();
        }

        int position = nums[0];
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (position == nums[i]) {
                result++;
            } else {
                result--;
            }
            if (result == 0) {
                if (++i < nums.length) {
                    position = nums[++i];
                    result++;
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return position;
    }
}

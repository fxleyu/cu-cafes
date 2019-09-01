package fx.leyu.leetcode.top0001to0050.problem01;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            Integer index = map.get(target - number);
            if (index == null) {
                map.put(number, i);
            } else {
                return new int[] {index, i};
            }
        }
        return null;
    }
}

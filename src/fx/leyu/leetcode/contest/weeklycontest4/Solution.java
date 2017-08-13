package fx.leyu.leetcode.contest.weeklycontest4;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,3,3};
        Solution solution = new Solution(nums);

        // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
        System.out.println(solution.pick(3));

        // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
        System.out.println(solution.pick(1));
    }
    
    
    private int[] nums = new int[0];
    private ArrayList<Integer> arr = new ArrayList<Integer>();
    
    public Solution(int[] nums) {
        if (nums != null) {
            this.nums = nums;
            arr = new ArrayList<Integer>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                arr.add(i);
            }
        }
    }
    
    public int pick(int target) {
        Collections.shuffle(arr);
        for (int index : arr) {
            if (nums[index] == target) {
                return index;
            }
        }
        return -1;
    }

}

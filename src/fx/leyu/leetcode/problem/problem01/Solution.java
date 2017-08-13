package fx.leyu.leetcode.problem.problem01;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) 
 * are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 */

public class Solution {
    
    public static void main(String[] args) {
        int[] result = new Solution().twoSum(new int[]{3,2,4}, 6);
        if(result!=null && result.length==2){
            System.out.println(result[0] + ", " + result[1]);
        }
    }
    
    public int[] twoSum(int[] nums, int target) {
        if (nums==null) {
            return null;
        }
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0; i<nums.length; i++) {
            int other = target-nums[i];
            if (map.containsKey(other)) {
                return new int[]{map.get(other), i+1};
            }
            map.put(nums[i], i+1);
        }
        return null;
    }

}

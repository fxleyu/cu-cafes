package fx.leyu.leetcode.problem.cleancode;

import java.util.HashMap;
import java.util.Map;

public class Solution01 {

    public static void main(String[] args) {
        
    }
    
    public int[] twoSum(int[] numbers, int target) {
        if (checkIllegalArgument(numbers)) {
            throw new IllegalArgumentException("Int array is illegal");
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<numbers.length; i++) {
            int number = target - numbers[i];
            if (map.containsKey(target - number)) {
                return new int[] {map.get(target), i+1};
            }
            map.put(number, i+1);
        }
        throw new IllegalArgumentException("No Result");
    }

    private boolean checkIllegalArgument(int[] numbers) {
        return numbers == null;
    }

}

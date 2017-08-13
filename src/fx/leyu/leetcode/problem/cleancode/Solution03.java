package fx.leyu.leetcode.problem.cleancode;

import java.util.HashMap;
import java.util.Map;

public class Solution03 {
    
    private Map<Integer, Integer> table = new HashMap<>();
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public void add(int input) {
        int count = table.containsKey(input) ? table.get(input) : 0;
        table.put(input, count + 1);
    }
    
    public boolean find(int val) {
        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            int num = entry.getKey();
            int y = val - num;
            if (y == num) {
                // For duplicates, ensure there are at least two individual numbers.
                if (entry.getValue() >= 2) {
                    return true;
                }
            } else if (table.containsKey(y)) {
                return true;
            }
        }
        return false;
    }

}

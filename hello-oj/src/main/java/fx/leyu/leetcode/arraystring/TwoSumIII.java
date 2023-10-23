package fx.leyu.leetcode.arraystring;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {
    
    private final Map<Integer, Integer> table = new HashMap<>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public void add(int input) {
        int count = table.containsKey(input) ? table.get(input) : 0;
        table.put(input, count);
    }
    
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            int number = entry.getKey();
            int y = value - number;
            if (y == number) {
                // For duplicates, ensure there are at least two individual numbers;
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

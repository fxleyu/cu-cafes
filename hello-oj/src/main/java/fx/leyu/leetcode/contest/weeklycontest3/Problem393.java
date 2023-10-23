package fx.leyu.leetcode.contest.weeklycontest3;

import java.util.HashMap;
import java.util.Map;

public class Problem393 {
    private final Map<Integer, String> map = new HashMap<>();
    {
        map.put(2, "110");
        map.put(3, "1110");
        map.put(4, "11110");
    }
    
    public boolean validUtf8(int[] data) {
        int index = 0;
        while (index < data.length) {
            String start = Integer.toBinaryString(data[index]);
            if (start.length() > 8) {
                return false;
            } 
            
            if (start.length() < 8) {
                index++;
                continue;
            }
            
            int num = start.indexOf('0');
            if (num < 0 || num > 4 || num == 1) {
                return false;
            }
            
            if (index + num > data.length) {
                return false;
            }
            
            for (int i = index + 1; i < index + num ; i++) {
                String str = Integer.toBinaryString(data[i]);
                if (str.length() != 8 || !str.startsWith("10")) {
                    return false;
                }
            }
            index += num;
        }
        
        return index == data.length;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem393().validUtf8(new int[]{197, 130, 1}));
        System.out.println(new Problem393().validUtf8(new int[]{235, 140, 4}));
        System.out.println(new Problem393().validUtf8(new int[]{235}));
        System.out.println(new Problem393().validUtf8(new int[]{145}));
        System.out.println(Integer.toBinaryString(145));
    }
}

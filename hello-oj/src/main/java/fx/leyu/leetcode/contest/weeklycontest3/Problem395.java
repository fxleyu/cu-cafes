package fx.leyu.leetcode.contest.weeklycontest3;

import java.util.HashMap;
import java.util.Map;

public class Problem395 {

    public static void main(String[] args) {
        String xx = "aaaaaaaaaaaaaaaabbbbbbbbbbbbaaaaaaabbbbbbbbbbbbcccccccccccdddddddddddddddddddeeeeeeeeeeeeeeefffffffffffffffgggggggggggggggggggghhhhhhhhhhhhhhhhiiiiiiiiiiiiiiiiiiiiiijjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkk";
        System.out.println(new Problem395().longestSubstring(xx, 20));
        System.out.println(new Problem395().longestSubstring("aaabb", 2));
        System.out.println(new Problem395().longestSubstring("ababbc", 2));

    }

    public int longestSubstring(String s, int k) {
        return longestSubstring(s, 0, s.length(), k);
    }

    private int longestSubstring(String s, int start, int end, int k) {
        if (end - start < k) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = start; i < end; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        int tempStart = start;
        int max = 0;
        for (int i = start; i < end; i++) {
            if (map.get(s.charAt(i)) < k) {
                int cal = longestSubstring(s, tempStart, i, k);
                max = Math.max(max, cal);
                tempStart = i + 1;
                continue;
            }
        }
        

        if (tempStart == start) {
            max = end - start;
        } else {
            int cal = longestSubstring(s, tempStart, end, k);
            max = Math.max(max, cal);
        }
        return max;

    }

}

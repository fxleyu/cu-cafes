package fx.leyu.leetcode.top0001to0050.problem03;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] book = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        book[0] = 1;
        int result = 1;
        for (int i = 1; i < s.length(); i++) {
            Integer beforeIndex = map.get(s.charAt(i));
            if (beforeIndex == null) {
                book[i] = book[i - 1] + 1;
            } else {
                book[i] = Math.min(book[i - 1] + 1, i - beforeIndex);
            }

            map.put(s.charAt(i), i);
            result = Math.max(result, book[i]);
        }
        return result;
    }
}

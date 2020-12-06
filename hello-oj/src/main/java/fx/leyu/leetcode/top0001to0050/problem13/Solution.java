package fx.leyu.leetcode.top0001to0050.problem13;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    private static final Map<Character, Integer> CHAR_TO_INT_MAP = new HashMap<>();
    static {
        CHAR_TO_INT_MAP.put('I', 1);
        CHAR_TO_INT_MAP.put('V', 5);
        CHAR_TO_INT_MAP.put('X', 10);
        CHAR_TO_INT_MAP.put('L', 50);
        CHAR_TO_INT_MAP.put('C', 100);
        CHAR_TO_INT_MAP.put('D', 500);
        CHAR_TO_INT_MAP.put('M', 1000);
    }

    public int romanToInt(String s) {
        int result = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (i + 1 < chs.length) {
                if (Objects.equals(chs[i], 'I')) {
                    if (Objects.equals(chs[i + 1], 'V') || Objects.equals(chs[i + 1], 'X')) {
                        result -= 1;
                    } else {
                        result += 1;
                    }
                    continue;
                } else if (Objects.equals(chs[i], 'X')) {
                    if (Objects.equals(chs[i + 1], 'L') || Objects.equals(chs[i + 1], 'C')) {
                        result -= 10;
                    } else {
                        result += 10;
                    }
                    continue;
                } else if (Objects.equals(chs[i], 'C')) {
                    if (Objects.equals(chs[i + 1], 'D') || Objects.equals(chs[i + 1], 'M')) {
                        result -= 100;
                    } else {
                        result += 100;
                    }
                    continue;
                }
            }
            Integer number =CHAR_TO_INT_MAP.get(chs[i]);
            if (Objects.isNull(number)) {
                throw new IllegalArgumentException(s);
            }
            result += number;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = new Solution().romanToInt("MCMXCIV");
        System.out.println(x);
    }
}

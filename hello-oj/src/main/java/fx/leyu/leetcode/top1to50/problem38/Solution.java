package fx.leyu.leetcode.top1to50.problem38;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final Map<Integer, String> CACHE = new HashMap<>();

    static {
        String value = "1";
        int index = 1;
        CACHE.put(1, value);
        for (int i = 0; i < 30; i++) {
            CACHE.put(index++, value);
            value = nextString(value);
        }
    }

    private static String nextString(String value) {
        char[] chs = value.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chs.length; ) {
            char ch = chs[i];
            int next = nextDiffValue(chs, i);
            builder.append(next - i).append(ch);
            i = next;
        }
        return builder.toString();
    }

    private static int nextDiffValue(char[] chs, int i) {
        char ch = chs[i++];
        while (i < chs.length) {
            if (chs[i] != ch) {
                return i;
            }
            i++;
        }
        return i;
    }

    public String countAndSay(int n) {
        String result =  CACHE.get(n);
        if (result == null) {
            throw  new IllegalArgumentException("illegal input " + n);
        }
        return result;
    }
}

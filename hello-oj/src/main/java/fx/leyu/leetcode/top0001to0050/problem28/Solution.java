package fx.leyu.leetcode.top0001to0050.problem28;

import java.util.Objects;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (Objects.isNull(haystack)
                || Objects.isNull(needle)
                || haystack.length() < needle.length()) {
            return -1;
        }

        if (haystack.length() == needle.length()) {
            return Objects.equals(haystack, needle) ? 0 : -1;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (match(needle, haystack, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean match(String needle, String haystack, int start) {
        for (int i =0; i < needle.length(); i++) {
            if (!Objects.equals(needle.charAt(i), haystack.charAt(i + start))) {
                return false;
            }
        }
        return true;
    }
}

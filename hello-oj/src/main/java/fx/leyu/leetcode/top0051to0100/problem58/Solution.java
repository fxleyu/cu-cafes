package fx.leyu.leetcode.top0051to0100.problem58;

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int result = 0;
        for (int i = s.length(); i > 0; i--) {
            if (s.charAt(i - 1) == ' ') {
                if (result == 0) {
                    continue;
                } else {
                    break;
                }
            }
            result++;

        }

        return result;
    }
}

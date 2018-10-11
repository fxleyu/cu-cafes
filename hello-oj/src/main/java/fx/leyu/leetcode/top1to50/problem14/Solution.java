package fx.leyu.leetcode.top1to50.problem14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 2) {
            return strs == null || strs.length == 0 ? "" : strs[0] == null ? "" : strs[0];
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = longestCommonPrefix(result, strs[i]);
        }
        return result;
    }

    private String longestCommonPrefix(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return "";
        }
        int min = str1.length() > str2.length() ? str2.length() : str1.length();
        for (int i = 0; i < min; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, min);
    }
}

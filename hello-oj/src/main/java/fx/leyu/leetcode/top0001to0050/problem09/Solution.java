package fx.leyu.leetcode.top0001to0050.problem09;

public class Solution {
    public boolean isPalindrome(int x) {
        char[] chs = Integer.toString(x).toCharArray();
        for (int i = 0, j = chs.length - 1; i < j; i++,j--) {
            if (chs[i] != chs[j]) {
                return false;
            }
        }
        return true;
    }
}

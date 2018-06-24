package fx.leyu.leetcode.problem.cleancode;

import java.util.Arrays;

public class Solution10 {

    public static void main(String[] args) {
        System.out.println(new Solution10().lengthOfLongestSubstring("abcdefghig"));
    }
    
    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int i = 0;
        int maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            while (exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(j - i +1, maxLen);
        }
        
        return maxLen;
    }
    
    public int lengthOfLongestSubstring2(String s) {
        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        int i = 0;
        int maxLen = 0;
        for (int j=0; j < s.length(); j++) {
            if (charMap[s.charAt(j)] >= i) {
                i = charMap[s.charAt(j)] + 1;
            }
            charMap[s.charAt(j)] = j;
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    } 

}

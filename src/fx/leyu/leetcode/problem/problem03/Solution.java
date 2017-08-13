package fx.leyu.leetcode.problem.problem03;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * Subscribe to see which companies asked this question
 *
 * Hide Tags Hash Table Two Pointers String
 * Hide Similar Problems (H) Longest Substring with At Most Two Distinct Characters
 * 
 * ************************************************
 * ********* The test cases is essential**********
 */
/*
 * ��������������Ҫ
 */

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("aaaaaaaaaaa"));
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring(""));
        System.out.println(new Solution().lengthOfLongestSubstring("abb"));
        System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
    }
    
    public int lengthOfLongestSubstring(String s) {
        if (s==null) {
            return 0;
        }
        
        int max = -1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chs = s.toCharArray();
        
        int start = 0;
        for (int i=0; i<chs.length; i++) {
           if (map.containsKey(chs[i]) && map.get(chs[i])>=start) {
               int index = map.get(chs[i]);
               
               int tempMax = i - start;
               start = index==start? start+1 : index+1;
               
               if(tempMax > max){
                   max = tempMax;
               }
           }
           map.put(chs[i], i);
        }
        
        int tempMax = chs.length - start;
        if (tempMax > max) {
            max = tempMax;
        }
        
        return max;
    }

}

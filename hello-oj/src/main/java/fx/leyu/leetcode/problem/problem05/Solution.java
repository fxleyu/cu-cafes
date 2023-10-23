package fx.leyu.leetcode.problem.problem05;


/**
 * 
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there 
 * exists one unique longest palindromic substring.
 *
 * Subscribe to see which companies asked this question
 *
 * Hide Tags String
 * Hide Similar Problems (H) Shortest Palindrome (E) Palindrome Permutation
 *
 *
 */
public class Solution {
    
    private static final int FAIL = -1;
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome(""));
        System.out.println(new Solution().longestPalindrome("q")); //add on end
        System.out.println(new Solution().longestPalindrome("qq")); //Wrong Answer
        System.out.println(new Solution().longestPalindrome("abc"));
        System.out.println(new Solution().longestPalindrome("aaa"));
        System.out.println(new Solution().longestPalindrome("xabay"));
        System.out.println(new Solution().longestPalindrome("xaba"));
        System.out.println(new Solution().longestPalindrome("abay"));
        System.out.println(new Solution().longestPalindrome("xabbay"));
        System.out.println(new Solution().longestPalindrome("xabba"));
        System.out.println(new Solution().longestPalindrome("abbay"));
    }
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        char[] chs = s.toCharArray();
        int start = 0; // [
        int maxLength = 1; // )
        for (int i=0; i<s.length(); i++) {
            int startA = returnPalindromeStartA(chs, i);
            int startB = returnPalindromeStartB(chs, i);
            int length = (startB!=FAIL && startA >= startB) ? (2*(i-startB+1)) : (2*(i-startA)+1);
            if (length > maxLength) {
               start = (length%2==0) ? startB : startA;
               maxLength = length;
            }
        }
        
        return s.substring(start, start+maxLength);
    }

    private int returnPalindromeStartA(char[] chs, int i) {
        int result = i;
        while (result > -1) {
            int end = 2*i -result;
            if(end < chs.length && chs[end]==chs[result]){
                result--;
            } else {
                break;
            }
        }
        return result+1;
    }

    private int returnPalindromeStartB(char[] chs, int i) {
        if (i+1 == chs.length || chs[i] != chs[i+1]) {
            return FAIL;
        }
        
        int result = i-1;
        while(result>-1) {
            int end = 2*i-result+1;
            if (end < chs.length && chs[result] == chs[end]) {
                result--;
            } else {
                break;
            }
        }
        
        return result+1;
    }
}

package fx.leyu.leetcode.problem.problem09;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * click to show spoilers.
 * 
 * Subscribe to see which companies asked this question
 * 
 * Hide Tags Math
 * Hide Similar Problems (E) Palindrome Linked List
 * 
 * 
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(0));
        System.out.println(new Solution().isPalindrome(1));
        System.out.println(new Solution().isPalindrome(-1));
        System.out.println(new Solution().isPalindrome(12));
        System.out.println(new Solution().isPalindrome(-12));
        System.out.println(new Solution().isPalindrome(121));
        System.out.println(new Solution().isPalindrome(-121));
        System.out.println(new Solution().isPalindrome(123));
        System.out.println(new Solution().isPalindrome(-123));
        System.out.println(new Solution().isPalindrome(1221));
        System.out.println(new Solution().isPalindrome(-1221));
    }
    
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int temp = x;
        int other = 0;
        while (temp > 0) {
            other = other * 10 + temp % 10;
            temp = temp / 10;
        }
        
        return x == other ? true : false;
    }

}

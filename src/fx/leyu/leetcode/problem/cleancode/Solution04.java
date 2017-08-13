package fx.leyu.leetcode.problem.cleancode;

public class Solution04 {

    public static void main(String[] args) {
        System.out.println(new Solution04().isPalindrome(""));
    }
    
    public boolean isPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("error: input is " + s);
        }
        
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i<j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}

package fx.leyu.leetcode.problem.problem07;

/*
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * click to show spoilers.
 * 
 * Subscribe to see which companies asked this question
 * 
 * Hide Tags Math
 * Hide Similar Problems (E) String to Integer (atoi)
 * 
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse(321));
        System.out.println(new Solution().reverse(-0));
        System.out.println(new Solution().reverse(0));
        System.out.println(new Solution().reverse(-100));
        System.out.println(new Solution().reverse(100));
        System.out.println(new Solution().reverse(1534236469));
    }
    
    public int reverse(int x) {
        String xString = x+"";
        xString = reverse(xString, x<0 ? 1 : 0, xString.length()-1);
        int result = 0;
        try {
            result = Integer.valueOf(xString);
        } catch (Exception e) {
            return 0;
        }
        return result;
    }

    private String reverse(String xString, int i, int j) {
        char[] chs = xString.toCharArray();
        for ( ; i<j; i++,j--) {
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
        }
        return new String(chs);
    }
}

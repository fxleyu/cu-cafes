package fx.leyu.leetcode.contest.weeklycontest2;

public class Problem389 {

    public static void main(String[] args) {
        System.out.println(new Problem389().findTheDifference("abcde", "afbcde"));
    }
    
    public char findTheDifference(String s, String t) {
        if (s == null || t == null || s.length() + 1 != t.length()) {
            throw new IllegalArgumentException("error: s = " + s + ", t = " + t);
        }
        
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        char result = tChars[0];
        for (int i = 1; i < tChars.length; i++) {
            result ^= tChars[i];
        }
        for (int i = 0; i < sChars.length; i++) {
            result ^= sChars[i];
        }
        
        return result;
    }

}

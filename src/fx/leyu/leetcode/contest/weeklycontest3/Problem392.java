package fx.leyu.leetcode.contest.weeklycontest3;

public class Problem392 {

    public static void main(String[] args) {
        System.out.println(new Problem392().isSubsequence("abc", "ahbgdc"));
        System.out.println(new Problem392().isSubsequence("axc", "ahbgdc"));
    }
    
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (index == s.length()) {
                return true;
            }
            if (s.charAt(index) == t.charAt(i)) {
                index ++;
            }
        }
        
        return index == s.length();
    }

}

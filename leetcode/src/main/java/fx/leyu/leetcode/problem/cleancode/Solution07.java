package fx.leyu.leetcode.problem.cleancode;

public class Solution07 {
    public static void main(String[] args) {
        
    }
    
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length);
        for (int i=0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverse(s, i, j);
                i = j + 1;
            }
        } 
    }

    private void reverse(char[] s, int start, int end) {
        int max = (end - start) / 2;
        for (int i = 0; i < max; i++) {
            char temp = s[start + i];
            s[start + i] = s[end -i - 1];
            s[end -i - 1] = temp;
        }
        
    }
}

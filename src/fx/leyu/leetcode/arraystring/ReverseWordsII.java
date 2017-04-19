package fx.leyu.leetcode.arraystring;

public class ReverseWordsII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public static void reverseWords(char[] s) {
        reverse(s, 0, s.length);
        for (int i = 0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverse(s, i, j);
                i = j + 1;
            }
        }
    }

    private static void reverse(char[] s, int begin, int end) {
        for (int i = 0; i < (end - begin) / 2; i++) {
            char temp = s[begin + i];
            s[begin + i] = s[end - i - 1];
            s[end - i -1] = temp;
        }
    }

}

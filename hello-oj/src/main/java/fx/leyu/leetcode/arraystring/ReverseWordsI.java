package fx.leyu.leetcode.arraystring;

public class ReverseWordsI {

    public static void main(String[] args) {
        System.out.println(reverseWords(" the sky  is blue "));
    }
    
    public static String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (reversed.length() != 0) {
                    reversed.append(' ');
                }
                reversed.append(s, i, j);
            }
        }
        return reversed.toString();
    }

}

package fx.leyu.leetcode.problem.cleancode;

public class Solution08 {

    private static final int maxDiv10 = Integer.MAX_VALUE / 10;

    public static void main(String[] args) {
        // TODO Auto-generated method stu

    }

    public int atoi(String str) {
        int i = 0;
        int n = str.length();

        while (i < n && Character.isWhitespace(str.charAt(i))) {
            i++;
        }

        int sign = 1;
        if (i < n && str.charAt(i) == '+') {
            i++;
        } else if (i < n && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        int num = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));
            if (num > maxDiv10 || num == maxDiv10 && digit >= 8) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return sign * num;
    }

}

package fx.leyu.leetcode.top1to50.problem07;

public class Solution {
    public int reverse(int x) {
        boolean isMinus = x < 0;

        char[] chs = Integer.toString(x).toCharArray();
        StringBuilder builder = new StringBuilder(isMinus ? "-" : "");
        int min = isMinus ? 1 : 0;
        for (int i = chs.length - 1; i >= min; i--) {
            builder.append(chs[i]);
        }
        long newNumber = Long.valueOf(builder.toString());
        if (isMinus) {
            return newNumber < (long) Integer.MIN_VALUE ? 0 : (int)newNumber;
        }
        return newNumber > (long) Integer.MAX_VALUE ? 0 : (int)newNumber;
    }
}

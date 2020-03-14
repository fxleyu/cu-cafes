package fx.leyu.leetcode.lcp0001to0050.problem02;

public class Solution {
    public int[] fraction(int[] cont) {
        if (cont == null || cont.length < 1) {
            throw new IllegalArgumentException("con's length must be bigger than 1");
        }

        int[] result = new int[]{cont[cont.length-1], 1};
        for (int i = cont.length - 2; i >= 0; i--) {
            int a = result[0];
            int b = result[1];
            result[0] = cont[i] * a + b;
            result[1] = a;
        }

        return fractionOfNum(result);
    }

    private int[] fractionOfNum(int[] result) {
        int max = Math.min(result[0], result[1]) / 2;
        if (max < 2) {
            return result;
        }
        for (int i = max; i > 1; i--) {
            if (result[0] % i == 0 && result[1] % i == 0) {
                return fractionOfNum(new int[]{result[0] / i, result[1] / i});
            }
        }
        return result;
    }
}

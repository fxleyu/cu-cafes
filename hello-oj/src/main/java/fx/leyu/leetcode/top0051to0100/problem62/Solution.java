package fx.leyu.leetcode.top0051to0100.problem62;

public class Solution {
    // 排列组合问题 C（M+N-2, N-1）
    public int uniquePaths(int m, int n) {
        int min = Math.min(m, n);
        long upper = multiply(1, min - 1);
        long down = multiply(m + n - min, m + n - 2);
        return (int) (down / upper);
    }

    private long multiply(int from, int end) {
        long result = 1;
        for (int i = from; i <= end; i++) {
            result = result * i;
        }
        return result;
    }
}

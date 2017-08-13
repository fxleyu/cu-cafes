package fx.leyu.leetcode.contest.weeklycontest4;

public class Problem396 {

    public static void main(String[] args) {
        int x = new Problem396().maxRotateFunction(new int[] { 768, -954, 35, -656, 999, 88, -4 });
        System.out.println(x);
        try {
            System.out.println("Start");
            System.exit(0);
            System.out.println("End");
        } finally {
            System.out.println("Hello End!");
        }
    }

    public int maxRotateFunction(int[] A) {
        if (A == null || A.length < 1) {
            return 0;
        }

        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            caluteResult(A, i, result);
        }

        int max = Integer.MIN_VALUE;
        for (int value : result) {
            max = Math.max(value, max);
        }

        return max;
    }

    private void caluteResult(int[] a, int k, int[] result) {
        for (int i = 0; i < a.length; i++) {
            result[i] += k * a[(k + i) % a.length];
        }
    }

}

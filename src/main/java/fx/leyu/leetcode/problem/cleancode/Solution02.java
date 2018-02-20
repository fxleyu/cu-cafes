package fx.leyu.leetcode.problem.cleancode;

public class Solution02 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public int[] twoSum(int[] numbers, int target) {
        // Assume input is already sorted.
        int i = 0;
        int j = numbers.length -1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i+1, j+1};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    public int[] twoSumTemp(int[] numbers, int target) {
        // Assume input is already sorted.
        for (int i = 0; i < numbers.length; i++) {
            int j = bsearch(numbers, target - numbers[i], i+1);
            if (j != -1) {
                return new int[] { i+1, j+1 };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private int bsearch(int[] A, int key, int start) {
        int L = start;
        int R = A.length - 1;
        while (L < R) {
            int M = (L + R) / 2;
            if (A[M] < key) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return (L == R && A[L] == key) ? L : -1;
    }
}

package fx.leyu.leetcode.contest.weeklycontest153;

import org.junit.Assert;
import org.junit.Test;

public class Problem5182 {
    @Test
    public void test() {
        Assert.assertEquals(4, new Solution().maximumSum(new int[]{1, -2, 0, 3}));
        Assert.assertEquals(17, new Solution().maximumSum(new int[]{8, -1, 6, -7, -4, 5, -4, 7, -6}));
    }

    class Solution {
        public int maximumSum(int[] arr) {
            checkArg(arr);
            int[] addUpArray = new int[arr.length];
            int result = arr[0];
            addUpArray[0] = result;
            for (int i = 1; i < arr.length; i++) {
                int maxWithI = maximumSumWithIAndUpdateAddUpArray(addUpArray, arr, i, arr[i]);
                result = Math.max(result, maxWithI);
            }
            return result;
        }

        private int maximumSumWithIAndUpdateAddUpArray(int[] addUpArray, final int[] arr, final int i, final int value) {
            int minValue = value;
            int maxSum = value;
            addUpArray[i] = value;
            for (int index = i - 1; index >= 0; index--) {
                minValue = Math.min(minValue, arr[index]);
                addUpArray[index] += value;
                int tempMaxSum = Math.max(addUpArray[index], addUpArray[index] - minValue);
                maxSum = Math.max(tempMaxSum, maxSum);
            }
            return maxSum;
        }

        private void checkArg(int[] arr) {
            if (arr == null || arr.length < 1) {
                throw new IllegalArgumentException("input error: empty arr");
            }
        }
    }
}

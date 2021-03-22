package fx.leyu.leetcode.top0001to0050.problem35;

public class Solution {
    // 官方解法
    public int searchInsertX(int[] A, int target) {
        int L = 0, R = A.length - 1;
        while (L < R) {
            int M = (L + R) / 2;
            if (A[M] < target) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return (A[L] < target) ? L + 1 : L;
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }

        return findIndex(nums, target, 0, nums.length - 1);
    }

    private int findIndex(int[] nums, int target, int start, int end) {
        if (start >= end) {
            return insertIndex(nums, target, start);
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        return nums[mid] > target
                ? findIndex(nums, target, start, mid - 1)
                : findIndex(nums, target, mid + 1, end);
    }

    /**
     * 对于查询失败的位置 i：默认 i - 1 小于目标值；i + 1 大于目标值。如果 i 对应值大于目标值，插入 i；否则，插入 i + 1 位置。
     */
    private int insertIndex(int[] nums, int target, int index) {
        return nums[index] >= target ? index : index + 1;
    }
}

package fx.leyu.leetcode.top0051to0100.problem88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || m < 0 || n < 0 || nums1.length < m + n) {
            throw new IllegalArgumentException("ERROR input");
        }

        int resultIndex = m + n;
        while (m > 0 && n > 0) {
            nums1[--resultIndex] = nums1[m - 1] > nums2[n - 1] ? nums1[--m] : nums2[--n];
        }
        if (n > 0) {
            while (n > 0) {
                nums1[--resultIndex] = nums2[--n];
            }
        }
    }
}

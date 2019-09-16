package fx.leyu.leetcode.top0001to0050.problem04;

import java.util.Objects;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        assertNotNull(nums1, nums2);
        int mid = (nums1.length + nums2.length) / 2;
        boolean isOdd = (nums1.length + nums2.length) % 2 != 0;
        mid = isOdd ? mid : mid - 1;

        int a1 = 0, a2 = 0;
        for (int index = 0; index < mid; index++) {
            if (a1 == nums1.length) {
                a2++;
            } else if (a2 == nums2.length || nums1[a1] < nums2[a2]) {
                a1++;
            } else {
                a2++;
            }
        }

        if (a1 == nums1.length) {
            return isOdd ? nums2[a2] : (nums2[a2] + nums2[a2 + 1]) / 2.0;
        } else if (a2 == nums2.length) {
            return isOdd ? nums1[a1] : (nums1[a1] + nums1[a1 + 1]) / 2.0;
        } else if (isOdd) {
            return Math.min(nums1[a1], nums2[a2]);
        }
        int a = nums1[a1] < nums2[a2] ? nums1[a1++] : nums2[a2++];
        int b = (a1 == nums1.length) ? nums2[a2] : ((a2 == nums2.length) ? nums1[a1] : Math.min(nums1[a1], nums2[a2]));
        return (a + b) / 2.0;
    }

    private void assertNotNull(int[] nums1, int[] nums2) {
        if (Objects.isNull(nums1) || Objects.isNull(nums2)) {
            throw new IllegalArgumentException("findMedianSortedArrays args cannot be null!");
        }

        if (nums1.length + nums2.length == 0) {
            throw new IllegalArgumentException("findMedianSortedArrays args cannot be all empty!");
        }
    }
}

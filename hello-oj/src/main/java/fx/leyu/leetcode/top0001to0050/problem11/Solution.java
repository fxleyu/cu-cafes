package fx.leyu.leetcode.top0001to0050.problem11;

import java.util.Objects;

/**
 * @author fxleyu
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        // 49
        System.out.println(new Solution().maxArea(arr));
    }

    public int maxArea(int[] height) {
        if (Objects.isNull(height) || height.length < 2) {
            throw new IllegalArgumentException("height.length must >= 2");
        }

        int result = 0;
        for (int i = 1; i < height.length; i++) {
            int max = maxAreaWithEnd(height, i);
            result = Math.max(max, result);
        }
        return result;
    }

    private int maxAreaWithEnd(int[] height, int end) {
        int result = 0;
        for (int i = 0; i < end; i++) {
            int area = (end - i) * Math.min(height[i], height[end]);
            result = Math.max(area, result);
        }
        return result;
    }
}

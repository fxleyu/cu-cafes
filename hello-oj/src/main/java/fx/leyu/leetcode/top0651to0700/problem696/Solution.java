package fx.leyu.leetcode.top0651to0700.problem696;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1 || g) {
                    grid[i][j] = -1;
                }
            }
        }
        return -1;
    }
}

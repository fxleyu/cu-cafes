package fx.leyu.leetcode.lcp0001to0050.problem03;

public class Solution {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        if (command == null || obstacles == null || x < 0 || y < 0) {
            throw new IllegalArgumentException("illegal args");
        }

        if (command.length() == 0) {
            return x == 0 && y == 0;
        }

        int fx = 0;
        int fy = 0;
        while (true) {
            if (checkDanger(obstacles, fx, fy)) {
                return false;
            }
            if (fx > x || fy > y) {
                return false;
            }
            if (fx == x || fy == y) {
                return true;
            }
            for (char ch : command.toCharArray()) {
                if ('U' == ch) {
                    fy++;
                } else if ('R' == ch) {
                    fx++;
                } else {
                    throw new IllegalArgumentException("illegal command");
                }
                if (checkDanger(obstacles, fx, fy)) {
                    return false;
                }
                if (fx > x || fy > y) {
                    return false;
                }
                if (fx == x || fy == y) {
                    return true;
                }
            }
        }
    }

    private boolean checkDanger(int[][] obstacles, int fx, int fy) {
        for (int[] obstacle : obstacles) {
            if (obstacle == null || obstacle.length != 2) {
                throw new IllegalArgumentException("obstacles args error");
            }
            if (obstacle[0] == fx && obstacle[1] == fx) {
                return true;
            }
        }
        return false;
    }
}

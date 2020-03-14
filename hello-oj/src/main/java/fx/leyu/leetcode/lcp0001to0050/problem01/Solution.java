package fx.leyu.leetcode.lcp0001to0050.problem01;

/**
 * 简单问题：LCP 1. 猜数字
 * https://leetcode-cn.com/problems/guess-numbers/
 */
class Solution {
    public int game(int[] guess, int[] answer) {
        if (guess == null || answer == null || guess.length != 3 || answer.length != 3) {
            throw new IllegalArgumentException("args' length is not 3");
        }

        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += (guess[i] == answer[i] ? 1 : 0);
        }
        return result;
    }
}
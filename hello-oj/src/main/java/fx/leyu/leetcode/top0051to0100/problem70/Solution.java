package fx.leyu.leetcode.top0051to0100.problem70;

public class Solution {
    public int climbStairs(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("ERROR input");
        }

        int result = 0;
        int a1 = 1;
        int a2 = 0;
        for (int i = 0; i < n; i++) {
            result = a1 + a2;
            a2 = a1;
            a1 = result;
        }
        return result;
    }

    /**
     *  F(0) = 1;
     *  F(1) = F(0)
     *  F(2) = F(1) + F(0)
     *  ....
     *  F(n) = F(n -1) + F(n - 2)
     *
     *  =====>
     *
     *  F(0) = 1;
     *  F(1) = 1;
     *  F(n) = F(n - 1) + F(n - 2);  // n > 1
     *
     *  ????
     *
     */

    // office
    public int climbStairs1(int n) {
        int p = 1, q = 1;
        for (int i = 2; i <= n; i++) {
            int temp = q;
            q += p;
            p = temp;
        }
        return q;
    }
}

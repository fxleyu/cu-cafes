package fx.leyu.leetcode.contest.weeklycontest153;

import org.junit.Assert;
import org.junit.Test;

public class Problem5181 {
    @Test
    public void test() {
        int[] distance = {1, 2, 3, 4};
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.distanceBetweenBusStops(distance, 0, 1));
        Assert.assertEquals(3, solution.distanceBetweenBusStops(distance, 0, 2));
        Assert.assertEquals(4, solution.distanceBetweenBusStops(distance, 0, 3));
    }
}

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        check(distance, start, destination);
        int min = Math.min(start, destination);
        int max = Math.max(start, destination);
        int other = 0;
        int one = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= min && i < max) {
                one += distance[i];
            } else {
                other += distance[i];
            }
        }
        return Math.min(one, other);
    }

    private void check(int[] distance, int start, int destination) {
        if (distance == null || distance.length <= start || distance.length <= destination) {
            throw new IllegalArgumentException("error input");
        }
    }
}
package fx.leyu.leetcode.contest.weeklycontest2;

public class Problem390 {

    public static void main(String[] args) {
        for(int i = 1; i < 23; i++) 
        System.out.println(i + " = " + new Problem390().lastRemaining(i));
    }
    
    public int lastRemaining(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("error: n = " + n);
        }
        
        int remain = n;
        int index = 0;
        int increase = 1;
        final int[] minAndMax = new int[]{1, n};
        
        while (remain > 1) {
            handleMinAndMax(n, remain, index, increase, minAndMax);
            
            remain /= 2;
            index++;
            increase *= 2;
        }
        
        return minAndMax[0];
    }

    private void handleMinAndMax(int n, int remain, int index, int increase, int[] minAndMax) {
        if (remain % 2 == 1) {
            minAndMax[0] = minAndMax[0] + increase;
            minAndMax[1] = minAndMax[1] - increase;
            return;
        }
        
        if (index % 2 == 0) {
            minAndMax[0] = minAndMax[0] + increase;
            minAndMax[1] = minAndMax[1] - increase;
            return;
        }
        
        minAndMax[0] = minAndMax[0];
        minAndMax[1] = minAndMax[1] - increase;
    }
}

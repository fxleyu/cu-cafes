package fx.leyu.leetcode.contest.weeklycontest2;

public class Problem391 {
  
    public static void main(String[] args) {
        int[][] rectangles1 = new int[][] { { 1, 1, 3, 3 }, { 3, 1, 4, 2 }, { 3, 2, 4, 4 }, { 1, 3, 2, 4 },
                { 2, 3, 3, 4 } };
        int[][] rectangles2 = new int[][] { { 1,1,2,3 }, { 1,3,2,4 }, { 3,1,4,2 }, { 3,2,4,4 }};
        
        System.out.println(new Problem391().isRectangleCover(rectangles1));
        System.out.println(new Problem391().isRectangleCover(rectangles2));
        //System.out.println(new Problem391().isRectangleCover(rectangles3));
        //System.out.println(new Problem391().isRectangleCover(rectangles4));
    }
    
    public boolean isRectangleCover(int[][] rectangles) {
        for (int i = 0; i < rectangles.length; i++) {
            
        }
        
        int[] min = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
        int[] max = new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE };
        long area = 0;
        
        for (int i = 0; i < rectangles.length; i++) {
            if (contain(min, max, rectangles[i])) {
                for (int j = 0; j < i; j++) {
                    if (contain(rectangles[i], rectangles[j])) {
                        return false;
                    }
                }   
            }
            
            handleMIN(rectangles[i], min);
            handleMAX(rectangles[i], max);
            area += handleArea(rectangles[i]);
        }

        long resultArea = handleArea(min, max);
        return resultArea == area;
    }

    private boolean contain(int[] min, int[] max, int[] is2) {
        if (min[0] >= is2[2] || min[1] >= is2[3]) {
            return false;
        }
        return max[0] > is2[0] && max[1] > is2[1];
    }

    private long handleArea(int[] min, int[] max) {
        return (long) (max[0] - min[0]) * (long) (max[1] - min[1]);
    }

    private boolean contain(int[] is, int[] is2) {
        if (is[0] >= is2[2] || is[1] >= is2[3]) {
            return false;
        }
        return is[2] > is2[0] && is[3] > is2[1];
    }

    private void handleMAX(int[] is, int[] max) {
        max[0] = is[2] > max[0] ? is[2] : max[0];
        max[1] = is[3] > max[1] ? is[3] : max[1];
    }

    private long handleArea(int[] is) {
        return (long) (is[3] - is[1]) * (long) (is[2] - is[0]);
    }

    private void handleMIN(int[] is, int[] min) {
        min[0] = is[0] < min[0] ? is[0] : min[0];
        min[1] = is[1] < min[1] ? is[1] : min[1];
    }

}

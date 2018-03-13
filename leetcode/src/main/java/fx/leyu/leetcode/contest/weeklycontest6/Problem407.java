package fx.leyu.leetcode.contest.weeklycontest6;

public class Problem407 {

    
    public int trapRainWater(int[][] heightMap) {
        int[][] work = new int[heightMap.length][heightMap[0].length];
        for (int i=0; i< work.length; i++) {
            for (int j=0; j<work[i].length; j++) {
                if (i == 0 || j == 0 || j == work[i].length-1 || i == work.length-1) {
                    work[i][j] = heightMap[i][j];
                    continue;
                }
                int min = Math.min(heightMap[i-1][j], heightMap[i][j-1]);
                min = Math.min(min, heightMap[i+1][j]);
                min = Math.min(min, heightMap[i][j+1]);
                work[i][j] = Math.max(min, heightMap[i][j]);
            }
        }
        
        drawOffWater(work, heightMap);
        
        return calcultateRainWater(work, heightMap);
    }

    private int calcultateRainWater(int[][] work, int[][] heightMap) {
        int result = 0;
        for (int i=0; i< work.length; i++) {
            for (int j=0; j<work[i].length; j++) {
                result += work[i][j] - heightMap[i][j];
            }
        }
        return result;
    }

    private void drawOffWater(int[][] work, int[][] heightMap) {
        for (int i=1; i< work.length-1; i++) {
            for (int j=1; j<work[i].length-1; j++) {
                int min = Math.min(work[i-1][j], work[i][j-1]);
                min = Math.min(min, work[i+1][j]);
                min = Math.min(min, work[i][j+1]);
                if (min > work[i][j]) {
                    drawOffWater(work, heightMap, i, j);
                }
            }
        }
    }

    private void drawOffWater(int[][] work, int[][] heightMap, int i, int j) {
        //makeSomeHeigthWater(work, i, j);
    }
}

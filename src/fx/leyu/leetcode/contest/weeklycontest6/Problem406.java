package fx.leyu.leetcode.contest.weeklycontest6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem406 {
    
    public static void main(String[] args) {
        int[][] input = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        new Problem406().reconstructQueue(input);
    }
    
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> workList = new ArrayList<>();
        for (int[] p : people) {
            workList.add(p);
        }
        
        Collections.sort(workList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        
        for (int i = 0; i < workList.size(); i++) {
            int[] now = workList.remove(i);
            int index = calculateIndex(now, i ,workList);
            workList.add(index, now);
        }
        
        workList.toArray(people);
        return people;
    }

    private int calculateIndex(int[] now, int max, List<int[]> workList) {
        int count = 0;
        for (int i=0; i<max; i++) {
            int[] work = workList.get(i);
            if (work[0] >= now[0]) {
                count++;
            }
            if (count > now[1]) {
                return i;
            }
        }
        return max;
    }
}

package fx.leyu.leetcode.arraystring;

import java.util.ArrayList;
import java.util.List;

public class MissingRnges {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public static List<String> findMissingRanges(int[] vals, int start, int end) {
        List<String> ranges = new ArrayList<>();
        int prev = start -1;
        for (int i = 0; i <= vals.length; i++) {
            int curr = (i == vals.length) ? end + 1 : vals[i];
            if (curr - prev >= 2) {
                ranges.add(getRange(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return ranges;
    }

    private static String getRange(int i, int j) {
        return i == j ? String.valueOf(i) : i + "->" + j;
    }

}

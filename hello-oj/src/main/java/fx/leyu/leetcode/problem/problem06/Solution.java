package fx.leyu.leetcode.problem.problem06;

public class Solution {

    public static void main(String[] args) {
        System.out.println("PAHNAPLSIIGYIR".equals(new Solution().convert("PAYPALISHIRING", 3)));
    }
    
    public String convert(String s, int numRows) {
        if(s==null || s.length()<1){
            return s;
        }
        
        char[] chs = s.toCharArray();
        char[] result = new char[chs.length];
        int index = fillFirstLine(chs,result, numRows);
        int firstEnd = index;
        for (int i=2; i<numRows; i++) {
            if(i-1 < chs.length){
                result[index++] = chs[i-1];
            }
            for(int j=1; j<firstEnd; j++){
                //TODO
                if(true){
                    
                }
            }
        }
        fillEndLine(chs,result, numRows, index);
        
        return new String(result);
    }

    private void fillEndLine(char[] chs, char[] result, int numRows, int index) {
        int x = (2*numRows - 2);
        int chsIndex = numRows - 1;
        for (;index<result.length; index++) {
            if(chsIndex < chs.length) {
                result[index] = chs[chsIndex];
                chsIndex += x;
            }
        }
    }

    private int fillFirstLine(char[] chs, char[] result, int numRows) {
        int x = 2*numRows - 2;
        int i=0;
        for (; i<result.length; i++) {
            int index = i*x;
            if (index<chs.length) {
                result[i] = chs[index];
            } else {
                return i;
            }
        }
        return i;
    }
}

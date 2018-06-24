package fx.leyu.leetcode.arraystring;

public class LongestSubstringWithoutRepeat {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public static int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int i = 0;
        int maxLen = 0;
        
        for (int j = 0; j < s.length(); j++) {
            while (exist[s.charAt(j)]) { //?
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(j-i+1, maxLen);
        }
        
        return maxLen;
    }

}

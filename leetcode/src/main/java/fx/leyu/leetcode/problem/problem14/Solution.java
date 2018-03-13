package fx.leyu.leetcode.problem.problem14;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * Subscribe to see which companies asked this question
 * 
 * Hide Tags String
 * 
 */
public class Solution {
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{"abc"}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{"abc", "abd"}));
    }
    
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        
        if (strs==null || strs.length < 1) {
            return result.toString();
        }
        
        int index = 0;
        while (true) {
            Character now = ithCharOfString(strs[0], index);
            if (now == null ) {
                return result.toString();
            }
            
            for(int i=1; i<strs.length; i++){
                Character temp = ithCharOfString(strs[i], index);
                if (temp == null || !temp.equals(now)) {
                    return result.toString();
                }
            }
            
            result.append(now);
            index++;
        }
    }

    private Character ithCharOfString(String string, int index) {
        if (string==null || index >= string.length()) {
            return null;
        }
        
        return string.charAt(index);
    }
}

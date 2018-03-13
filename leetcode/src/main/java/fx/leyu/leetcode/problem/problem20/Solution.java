package fx.leyu.leetcode.problem.problem20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * Subscribe to see which companies asked this question
 * 
 * Hide Tags Stack String
 * Hide Similar Problems (M) Generate Parentheses (H) Longest Valid Parentheses (H) Remove Invalid Parentheses
 * 
 */
public class Solution {
    
    private static Map<Character, Character> map = new HashMap<Character, Character>();
    
    static {        
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isValid(null));
        System.out.println(new Solution().isValid("()"));
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("(]"));
        System.out.println(new Solution().isValid("([)]"));
        System.out.println(new Solution().isValid(")}{({))[{{[}"));
    }
    
    public boolean isValid(String s) {
        if (s == null || s.length() < 1 || s.length()%2 == 1) {
            return false;
        }
        
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char ch : chs) {
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || !map.get(stack.pop()).equals(ch)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}

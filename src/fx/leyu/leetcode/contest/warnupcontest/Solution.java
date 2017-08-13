package fx.leyu.leetcode.contest.warnupcontest;

import java.util.Stack;

public class Solution {
    public int lengthLongestPath(String input) {
        String[] strs = input.split("\n");

        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (String str : strs) {
            String name = str.replaceAll("\t", "");
            int floorNum = str.length() - name.length();
            if (floorNum > stack.size()) {
                throw new IllegalArgumentException("error : " + input);
            } else {
                while (floorNum < stack.size()) {
                    stack.pop();
                }
            }
            
            int current = calFoorNum(stack, name);
            stack.push(current);
            if (current > max && name.contains(".")) {
                max = current;
            }
        }

        return max;
    }

    private int calFoorNum(Stack<Integer> stack, String name) {
        int current;
        if (stack.size() != 0) {
            current = stack.peek() + name.length() + 1;
        } else {
            current = name.length();
        }
        return current;
    }
}
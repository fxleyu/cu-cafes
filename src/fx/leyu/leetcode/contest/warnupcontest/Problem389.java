package fx.leyu.leetcode.contest.warnupcontest;

import java.util.Stack;

public class Problem389 {

    public static void main(String[] args) {
        String xx = "\t\t\tx";
        //System.out.println(xx.length());
        System.out.println(new Problem389().lengthLongestPath(
                "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

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
            if (current > max) {
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

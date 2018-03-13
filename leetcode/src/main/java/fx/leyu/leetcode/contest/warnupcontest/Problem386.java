package fx.leyu.leetcode.contest.warnupcontest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem386 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Integer> result = new Problem386().lexicalOrder(5000000);
        System.out.println("spend " + (System.currentTimeMillis() - start));
        for (int x : result) {
          //  System.out.println(x);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("value = " + n);
        }

        List<Integer> result = new ArrayList<>(n);
        Stack<Integer> workStack = new Stack<>();
        result.add(1);
        workStack.push(1);
        handleWorkStack(result, workStack, n);
        
        return result;
    }

    private void handleWorkStack(List<Integer> result, Stack<Integer> workStack, int n) {
        while (!workStack.isEmpty()) {
            increaseByMult10(result, workStack, n);
            int start = workStack.pop() + 1;
            while (start % 10 == 0 || start > n) {
                if (workStack.isEmpty()) {
                    return;
                }
                start = workStack.pop() + 1;
            }
            
            result.add(start);
            workStack.push(start);
        }
    }

    private void increaseByMult10(List<Integer> result, Stack<Integer> workStack, int max) {
        int value = workStack.peek();
        value *= 10;
        while (value <= max) {
            result.add(value);
            workStack.push(value);
            value *= 10;
        }
    }
}

package fx.leyu.leetcode.top1to50.problem20;

import java.util.*;

public class Solution {
    private static final Map<Character, Character> INFO_MAP = new HashMap<>();
    static {
        INFO_MAP.put(')', '(');
        INFO_MAP.put(']', '[');
        INFO_MAP.put('}', '{');
    }

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (Character ch : s.toCharArray()) {
            Character expected = INFO_MAP.get(ch);
            if (expected == null) {
                stack.offerFirst(ch);
            } else if (!expected.equals(stack.pollFirst())) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

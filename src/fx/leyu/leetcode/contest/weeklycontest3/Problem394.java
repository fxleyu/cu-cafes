package fx.leyu.leetcode.contest.weeklycontest3;

import java.util.Stack;

public class Problem394 {

    public static void main(String[] args) {
        System.out.println(new Problem394().decodeString("3[a]2[bc]"));
        System.out.println(new Problem394().decodeString("3[a2[c]]"));
        System.out.println(new Problem394().decodeString("2[abc]3[cd]ef"));

    }
    
    public String decodeString(String s) {        
        Stack<Character> work = new Stack<>();
        Stack<Character> temp = new Stack<>();
        
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            if (ch == ']') {
                handleRepeatChar(work, temp);
                temp.clear();
            } else {
                work.push(ch);
            }
        }
        
        char[] arr = new char[work.size()];
        int index = arr.length - 1;
        while (!work.isEmpty()) {
            arr[index--] = work.pop();
        }
        
        return new String(arr);
    }

    private void handleRepeatChar(Stack<Character> work, Stack<Character> temp) {
        gainRepeatChar(work, temp);
        int num = gainRepeatNum(work);
        pushRepeatCharToStack(work, temp, num);
    }

    private void pushRepeatCharToStack(Stack<Character> work, Stack<Character> temp, int num) {
        Character[] arr = new Character[temp.size()];
        temp.copyInto(arr);
        for (int i=0; i<num; i++) {
            for (int j=arr.length-1; j>=0; j--) {
                work.push(arr[j]);
            }
        }
    }

    private int gainRepeatNum(Stack<Character> work) {
        int num = 0;
        int mult = 1;
        while (!work.isEmpty()) {
            char ch = work.peek();
            if (ch >= '0' && ch <= '9') {
                ch = work.pop();
                num += mult * (ch - '0');
                mult *= 10;
            } else {
                return num;
            }
        }
        
        return num;
    }

    private void gainRepeatChar(Stack<Character> work, Stack<Character> temp) {
        while (!work.isEmpty()) {
            char ch = work.pop();
            if (ch == '[') {
                return;
            }
            temp.push(ch);
        }
        throw new IllegalArgumentException("error!");
    }
}

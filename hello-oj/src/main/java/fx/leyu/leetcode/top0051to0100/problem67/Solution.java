package fx.leyu.leetcode.top0051to0100.problem67;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i > -1 || j > -1; i--, j--) {
            int temp = i > -1 ? a.charAt(i) - '0' : 0;
            temp += j > -1 ? b.charAt(j) - '0' : 0;
            temp += carry;
            result.append(temp == 0 || temp == 2 ? "0" : "1");
            carry = temp > 1 ? 1 : 0;
        }
        if (carry > 0) {
            result.append("1");
        }
        return result.reverse().toString();
    }
}

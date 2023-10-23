package fx.leyu.leetcode.top0051to0100.problem66;

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length < 1) {
            throw new IllegalArgumentException("[ERROR] input is null or empty!");
        }

        int[] temp = new int[digits.length];
        int[] temp2 = new int[digits.length + 1];
        int carry = 1; // plus one
        for (int i = digits.length - 1; i > -1; i--) {
            int value = carry + digits[i];
            carry = value / 10;
            temp[i] = value % 10;
            temp2[i + 1] = temp[i];
        }
        temp2[0] = carry;

        return carry == 0 ? temp : temp2;
    }

    public int[] plusOne1(int[] digits) {
        if (digits == null || digits.length < 1) {
            throw new IllegalArgumentException("[ERROR] input is null or empty!");
        }

        int carry = 1; // plus one
        for (int i = digits.length - 1; i > -1; i--) {
            int value = carry + digits[i];
            carry = value / 10;
            digits[i] = value % 10;
        }
        if (carry == 0) {
            return digits;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        System.arraycopy(digits, 0, result, 1, result.length - 1);
        return result;
    }
}

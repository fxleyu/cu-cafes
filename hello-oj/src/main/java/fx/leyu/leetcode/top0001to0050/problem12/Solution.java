package fx.leyu.leetcode.top0001to0050.problem12;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final Map<Integer, String> NUMBER_TO_ROMAN = new HashMap<>();
    private static final Map<Integer, String> TEN_TO_ROMAN = new HashMap<>();
    private static final Map<Integer, String> HUNDRED_TO_ROMAN = new HashMap<>();
    private static final Map<Integer, String> THOUSAND_TO_ROMAN = new HashMap<>();
    static {
        NUMBER_TO_ROMAN.put(0, "");
        NUMBER_TO_ROMAN.put(1, "I");
        NUMBER_TO_ROMAN.put(2, "II");
        NUMBER_TO_ROMAN.put(3, "III");
        NUMBER_TO_ROMAN.put(4, "IV");
        NUMBER_TO_ROMAN.put(5, "V");
        NUMBER_TO_ROMAN.put(6, "VI");
        NUMBER_TO_ROMAN.put(7, "VII");
        NUMBER_TO_ROMAN.put(8, "VIII");
        NUMBER_TO_ROMAN.put(9, "IX");
        TEN_TO_ROMAN.put(0, "");
        TEN_TO_ROMAN.put(1, "X");
        TEN_TO_ROMAN.put(2, "XX");
        TEN_TO_ROMAN.put(3, "XXX");
        TEN_TO_ROMAN.put(4, "XL");
        TEN_TO_ROMAN.put(5, "L");
        TEN_TO_ROMAN.put(6, "LX");
        TEN_TO_ROMAN.put(7, "LXX");
        TEN_TO_ROMAN.put(8, "LXXX");
        TEN_TO_ROMAN.put(9, "XC");
        HUNDRED_TO_ROMAN.put(0, "");
        HUNDRED_TO_ROMAN.put(1, "C");
        HUNDRED_TO_ROMAN.put(2, "CC");
        HUNDRED_TO_ROMAN.put(3, "CCC");
        HUNDRED_TO_ROMAN.put(4, "CD");
        HUNDRED_TO_ROMAN.put(5, "D");
        HUNDRED_TO_ROMAN.put(6, "DC");
        HUNDRED_TO_ROMAN.put(7, "DCC");
        HUNDRED_TO_ROMAN.put(8, "DCCC");
        HUNDRED_TO_ROMAN.put(9, "CM");
        THOUSAND_TO_ROMAN.put(0, "");
        THOUSAND_TO_ROMAN.put(1, "M");
        THOUSAND_TO_ROMAN.put(2, "MM");
        THOUSAND_TO_ROMAN.put(3, "MMM");
    }

    public String intToRoman(int num) {
        if (num < 0 || num > 3999) {
            throw new IllegalArgumentException("0 <= num <= 999");
        }
        return THOUSAND_TO_ROMAN.get(num / 1000)
                + HUNDRED_TO_ROMAN.get((num % 1000) / 100)
                + TEN_TO_ROMAN.get((num % 100)  / 10)
                + NUMBER_TO_ROMAN.get(num % 10);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3545));
    }
}

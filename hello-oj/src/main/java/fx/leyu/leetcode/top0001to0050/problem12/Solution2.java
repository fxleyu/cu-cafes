package fx.leyu.leetcode.top0001to0050.problem12;

public class Solution2 {
    public String intToRoman(int num) {
        String[] roman = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] nums = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        StringBuilder str = new StringBuilder();
        int x = num;
        for (int i = nums.length - 1; x != 0; i--) {
            int a = x / nums[i];
            x = x % nums[i];
            for (int j = 0; j < a; j++) {
                str.append(roman[i]);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().intToRoman(4500));
    }
}

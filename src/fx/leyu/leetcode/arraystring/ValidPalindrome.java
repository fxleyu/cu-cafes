package fx.leyu.leetcode.arraystring;

public class ValidPalindrome {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(str.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(str.charAt(j))) {
                j++;
            }
            
            if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}

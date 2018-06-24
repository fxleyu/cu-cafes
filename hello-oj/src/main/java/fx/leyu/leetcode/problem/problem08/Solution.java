package fx.leyu.leetcode.problem.problem08;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge, 
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 *  You are responsible to gather all the input requirements up front.

 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature
 * accepts a const char * argument, please click the reload button  to reset your code definition.
 *
 * spoilers alert... click to show requirements for atoi.
 *
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first 
 * non-whitespace character is found. Then, starting from this character, takes an optional 
 * initial plus or minus sign followed by as many numerical digits as possible, and interprets 
 * them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, 
 * which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, 
 * or if no such sequence exists because either str is empty or it contains only whitespace 
 * characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned. If the correct value 
 * is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) 
 * is returned.
 *
 * Subscribe to see which companies asked this question
 *
 * Hide Tags Math String
 * Hide Similar Problems (E) Reverse Integer (H) Valid Number
 *
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi(" +11 "));
        System.out.println(new Solution().myAtoi("-11"));
        System.out.println(new Solution().myAtoi("11"));
        System.out.println(new Solution().myAtoi("")); // add 01
        System.out.println(new Solution().myAtoi("  -0012a42")); // error 01
    }
    
    public int myAtoi(String str) {
        str = handleString(str);
        if (str == null || str.length() < 1) {
            return 0;
        }
        
        str = str.trim();
        BigInteger now = new BigInteger("0");
        try {
            now = new BigInteger(str);
        } catch (Exception e) {
            return 0;
        }
        
        if(now.compareTo(new BigInteger(Integer.MAX_VALUE+""))>0) {
            return Integer.MAX_VALUE;
        } else if (now.compareTo(new BigInteger(Integer.MIN_VALUE+""))<0) {
            return Integer.MIN_VALUE;
        } else {
            return now.intValue();
        }
    }

    private String handleString(String str) {
        if(str==null || str.length()==0) {
            return str;
        }
        
        Pattern p = Pattern.compile("[+-]?[0-9]+");
        Matcher matcher = p.matcher(str.trim());
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        } else {
            return matcher.group();
        }
    }
}

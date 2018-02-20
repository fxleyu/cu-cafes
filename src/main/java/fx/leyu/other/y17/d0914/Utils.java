package fx.leyu.other.y17.d0914;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Utils {
    public static int sumByWhile(int[] arr) {
        int result = 0;
        int i = 0;
        while (i < arr.length) {
            result += arr[i];
        }
        return result;
    }
    
    public static int sumByFor(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result += num;
        }
        return result;
    }
    
    public static int sumByRecursion(int[] arr) {
        return sumByTopN(arr, arr.length);
    }

    private static int sumByTopN(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return arr[n - 1] + sumByTopN(arr, n - 1);
    }
    
    public static int[] mergeArray(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int min = Math.min(a.length, b.length);
        for(int i = 0; i < min; i++) {
            result[2*i] = a[i];
            result[2*i + 1] = b[i];
        }
        if (a.length == b.length) {
            return result;
        }
        
        int index = 2 * min;
        int[] c = a.length > b.length ? a : b;
        for(; index < result.length; index++) {
            result[index] = c[min++];
        }
        return result;
    }
    
    public static int[] fib100() {
        int[] result = new int[100];
        result[1] = 1;
        for (int i = 2; i < 100; i++) {
            result[i] = result[i - 1] + result[i -2];
        }
        return result;
    }
    
    public static BigInteger getMaxInteger(int[] arr) {
        StringBuilder builder = new StringBuilder();
        String[] strs = getStringArr(arr);
        Arrays.sort(strs);
        for (String str : strs) {
            builder.append(str);
        } 
        return new BigInteger(builder.toString());
    }

    private static String[] getStringArr(int[] arr) {
        String[] result = new String[arr.length];
        int i = 0;
        for (int num : arr) {
            result[i++] = Integer.toString(num);
        }
        return result;
    }
    
    public static List<String> getResultArr() {
        List<String> result = new LinkedList<>();
        for (int i = 1;i < 8; i++) {
            putResultArrToList(i, result);
        }
           
        return result;
    }

    private static void putResultArrToList(int i, List<String> result) {
        int number = c(8, i);
        // TODO
    }

    private static int c(int i, int i2) {
        int a = 1;
        return 0;
    }
}

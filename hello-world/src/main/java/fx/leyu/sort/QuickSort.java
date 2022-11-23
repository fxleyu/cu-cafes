package fx.leyu.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,0,9,9,7,6,5,3,2,1};
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int part = part(array, start, end);
        System.out.println("p : " + Arrays.toString(array));
        quickSort(array, start, part - 1);
        quickSort(array, part + 1, end);
    }

    private static int part(int[] array, int start, int end) {
        int value = array[start];
        int i = start + 1, j = end;
        while(true) {
            while(array[i] <= value) {
                if (i < j) {
                    i++;
                } else {
                    break;
                }
            }
            while(array[j] > value) {
                if (i < j) {
                    j--;
                } else {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        if (value <= array[j]) {
            array[start] = array[j - 1];
            array[j - 1] = value;
            return j - 1;
        }
        array[start] = array[j];
        array[j] = value;
        return j;

    }
}

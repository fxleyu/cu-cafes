package fx.leyu.algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int data[] = {10, 9, 8, 7, 6, 5, 5, 4, 3, 2, 1, 4};
        quickSort(data, 0, data.length - 1);
        out(data);
    }

    private static void quickSort(int[] data, int low, int high) {
        if (low >= high) {
            return;
        }

        int left = low;
        int right = high;
        int tempData = data[low];
        while (left < right) {
            //从右边开始，若是大于标志位，下标一直左移，即该数不动
            while (left < right && tempData < data[right]) {
                right--;
            }
            //此时是右边的数小于了标志位，则将该数放至左边
            if (left < right) {
                data[left] = data[right];
                left++;
            }

            //从左边开始，若是小于标志位，下标一直右移，即该数不动
            while (left < right && data[left] < tempData) {
                left++;
            }
            //此时是左边的数大于了标志位，则将该数放至右边
            if (left < right) {
                data[right] = data[left];
                right--;
            }
        }

        data[right] = tempData; //此时 left, right 相等，将标志位保存
        quickSort(data, low, right - 1);  //标志位左边的继续
        quickSort(data, right + 1, high); //标志位右边的继续
    }


    private static void out(int[] data) {
        System.out.println(Arrays.toString(data));
    }

}


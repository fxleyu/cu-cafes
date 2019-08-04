package fx.leyu.algorithm.sort;

import java.util.Arrays;

public class BinaryInsertSort {

    public static void main(String[] args) {
        int data[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1};
        binaryInsertSort(data);
        out(data);
    }

    private static void binaryInsertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int low = 0;
            int high = i;
            int temp = data[i];
            // 找到插入的位置
            while (low <= high) {
                int mid = (low + high) / 2;
                if (temp > data[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            // 插入位置后的全部右移
            for (int j = i - 1; j > high; j--) {
                data[j + 1] = data[j];
            }
            data[high + 1] = temp;
        }
    }

    private static void out(int[] data) {
        System.out.println(Arrays.toString(data));
    }
}

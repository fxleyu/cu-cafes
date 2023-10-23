package fx.leyu.algorithm.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] data = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 5};
        selectSort(data);
        out(data);

    }

    private static void selectSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[minIndex] > data[j]) {
                    minIndex = j;

                }
            }
            if (minIndex != i) {
                exchange(data, minIndex, i);
            }
        }

    }

    private static void exchange(int[] data, int minIndex, int i) {
        int temp = data[i];
        data[i] = data[minIndex];
        data[minIndex] = temp;
    }

    private static void out(int[] data) {
        System.out.println(Arrays.toString(data));
    }

}

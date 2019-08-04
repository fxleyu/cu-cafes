package fx.leyu.algorithm.sort;

public class QuickSort {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		int data[] = {1,2,3,4,5,6,7,8,9,10,1};

        int data[] = {10, 9, 8, 7, 6, 5, 5, 4, 3, 2, 1, 4};

        quickSort(data, 0, data.length - 1);

        out(data);

    }

    private static void quickSort(int[] data, int low, int high) {
        int i, j, flagTemp;
        if (low < high) {
            i = low;
            j = high;
            flagTemp = data[low];
            while (i < j) {
                //从右边开始，若是大于标志位，下标一直左移，即该数不动
                while (i < j && data[j] > flagTemp) {
                    j--;
                }

                //此时是右边的数小于了标志位，则将该数放至左边
                if (i < j) {
                    data[i] = data[j];
                    i++;
                }

                //从左边开始，若是小于标志位，下标一直右移，即该数不动
                while (i < j && data[i] < flagTemp) {
                    i++;
                }
                //此时是左边的数大于了标志位，则将该数放至右边
                if (i < j) {
                    data[j] = data[i];
                    j--;
                }
            }


            data[i] = flagTemp; //此时 i,j相等，将标志位保存

            quickSort(data, low, i - 1);  //标志位左边的继续
            quickSort(data, i + 1, high); //标志位右边的继续
        }
    }


    private static void out(int[] data) {
        // TODO Auto-generated method stub
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "   ");
        }
        System.out.println("");

    }

}


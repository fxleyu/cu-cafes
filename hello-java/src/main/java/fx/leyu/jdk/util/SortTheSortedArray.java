package fx.leyu.jdk.util;

import java.util.Arrays;
import java.util.Random;

public class SortTheSortedArray {

    public static void main(String[] args) {
        // Generate data
        int arraySize = 32768;
        int data[] = new int[arraySize];

        Random rnd = new Random(0);
        for (int c = 0; c < arraySize; ++c) {
            data[c] = rnd.nextInt(arraySize);
        }
        
        long start = System.nanoTime();
        // !!! With this, the next loop runs faster
        Arrays.sort(data);
        System.out.println("1 : " + (System.nanoTime() - start));

        start = System.nanoTime();
        Arrays.sort(data);
        System.out.println("2 : " + (System.nanoTime() - start));

    }

}

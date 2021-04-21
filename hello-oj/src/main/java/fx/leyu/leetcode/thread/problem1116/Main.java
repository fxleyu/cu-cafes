package fx.leyu.leetcode.thread.problem1116;

import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {
        ZeroEvenOdd1 zeroEvenOdd = new ZeroEvenOdd1(4);
        IntConsumer intConsumer = System.out::print;
        new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

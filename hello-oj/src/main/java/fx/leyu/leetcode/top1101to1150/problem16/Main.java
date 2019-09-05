package fx.leyu.leetcode.top1101to1150.problem16;

public class Main {
    public static void main(String[] args) {
        IntConsumer consumer = new IntConsumer();
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(7);
        new Thread(() -> {
            try {
                zeroEvenOdd.even(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "E").start();
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Z").start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "O").start();
    }
}

package fx.leyu.jdk.util.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class AlternatePrint {
    private static final CyclicBarrier barrierI = new CyclicBarrier(2);
    private static final CyclicBarrier barrierJ = new CyclicBarrier(2);
    private static final CyclicBarrier barrierK = new CyclicBarrier(2);
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Thread threadI = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    barrierI.await();
                    System.out.println("i");
                    barrierI.reset();
                    barrierJ.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadJ = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    barrierJ.await();
                    System.out.println("j");
                    barrierJ.reset();
                    barrierK.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadK = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    barrierK.await();
                    System.out.println("k");
                    barrierK.reset();
                    barrierI.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        threadI.start();
        threadJ.start();
        threadK.start();
        barrierI.await();
    }
}

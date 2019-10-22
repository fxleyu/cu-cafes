package fx.leyu.jdk.util.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 有i，j，k三个线程,，i线程输出i，j线程输出j， k线程输出k，
 * 要求，同时启动三个线程,，按顺序输出ijk，循环10次。
 *
 * @author fxleyu
 */
public class AlternatePrintOther {
    private static final Semaphore SEMAPHORE_I = new Semaphore(1);
    private static final Semaphore SEMAPHORE_J = new Semaphore(1);
    private static final Semaphore SEMAPHORE_K = new Semaphore(1);
    private static final int MAX_VALUE = 10;

    public static void main(String[] args) throws InterruptedException {
        Thread threadI = new Thread(() -> {
            for (int i = 0; i < MAX_VALUE; i++) {
                try {
                    SEMAPHORE_I.acquire();
                    System.out.println("i");
                    SEMAPHORE_J.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadJ = new Thread(() -> {
            for (int i = 0; i < MAX_VALUE; i++) {
                try {
                    SEMAPHORE_J.acquire();
                    System.out.println("j");
                    SEMAPHORE_K.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadK = new Thread(() -> {
            for (int i = 0; i < MAX_VALUE; i++) {
                try {
                    SEMAPHORE_K.acquire();
                    System.out.println("k");
                    SEMAPHORE_I.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        SEMAPHORE_I.acquire();
        SEMAPHORE_J.acquire();
        SEMAPHORE_K.acquire();
        threadI.start();
        threadJ.start();
        threadK.start();
        SEMAPHORE_I.release();
    }
}

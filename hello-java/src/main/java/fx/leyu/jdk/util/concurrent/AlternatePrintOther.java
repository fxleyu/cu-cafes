package fx.leyu.jdk.util.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 有i，j，k三个线程,，i线程输出i，j线程输出j， k线程输出k，
 * 要求，同时启动三个线程,，按顺序输出ijk，循环10次。
 */
public class AlternatePrintOther {
    private static final Semaphore semaphoreI = new Semaphore(1);
    private static final Semaphore semaphoreJ = new Semaphore(1);
    private static final Semaphore semaphoreK = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        Thread threadI = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreI.acquire();
                    System.out.println("i");
                    semaphoreJ.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadJ = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreJ.acquire();
                    System.out.println("j");
                    semaphoreK.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadK = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreK.acquire();
                    System.out.println("k");
                    semaphoreI.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        semaphoreI.acquire();
        semaphoreJ.acquire();
        semaphoreK.acquire();
        threadI.start();
        threadJ.start();
        threadK.start();
        semaphoreI.acquire();
    }
}

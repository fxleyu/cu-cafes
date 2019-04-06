package fx.leyu.jdk.util.concurrent;
public class Main {
    private static final Object LOCK = new Object();
    private volatile static int flag = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread threadI = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized(LOCK) {
                    while (flag != 0) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("i");
                    flag = 1;
                    LOCK.notifyAll();
                }
            }
        });
        Thread threadJ = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized(LOCK) {
                    while (flag != 1) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("j");
                    flag = 2;
                    LOCK.notifyAll();
                }
            }
        });
        Thread threadK = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized(LOCK) {
                    while (flag != 2) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("k");
                    flag = 0;
                    LOCK.notifyAll();
                }
            }
        });
        threadI.start();
        threadJ.start();
        threadK.start();
    }
}
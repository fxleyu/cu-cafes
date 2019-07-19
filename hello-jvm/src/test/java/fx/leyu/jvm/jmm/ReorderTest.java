package fx.leyu.jvm.jmm;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class ReorderTest {
    private int a = 0;
    private int b = 0;
    private int x = 0;
    private int y = 0;
    @Test
    public void test() throws InterruptedException {
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(2);
        new Thread(()->{
            try {
                start.await();
                a = 1;
                x = b;
                System.out.println("1  x = " + x + "; y = " + y);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                end.countDown();
            }
        }).start();
        new Thread(()->{
            try {
                start.await();
                b = 1;
                y = a;
                System.out.println("2  x = " + x + "; y = " + y);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                end.countDown();
            }
        }).start();
        start.countDown();
        end.await();
        System.out.println("x = " + x + "; y = " + y);
        System.out.println("Game over");
    }
}

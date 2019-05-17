package fx.leyu.jdk.lang;

import java.util.concurrent.TimeUnit;

public class VolatileDemo {
    private volatile Worker worker;

    public static void main(String[] args) {
        VolatileDemo demo = new VolatileDemo();
        demo.worker = new Worker();
        new Thread(demo.worker::print).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo.worker = new Worker();
        new Thread(demo.worker::print).start();
    }

    static class Worker {
        public void print() {
            System.out.println("[WORKER][START]" + this);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[WORKER][END]" + this);
        }
    }
}

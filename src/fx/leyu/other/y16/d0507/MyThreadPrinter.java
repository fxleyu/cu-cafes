package fx.leyu.other.y16.d0507;

public class MyThreadPrinter implements Runnable {
    
    private String name;
    private Objectx prev;
    private Objectx self;
    
    public MyThreadPrinter(String name, Objectx prev, Objectx self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }
    
    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.println(name);
                    count--;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    self.notifyAll();
                    try {
                        prev.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Objectx a = new Objectx("A");
        Objectx b = new Objectx("B");
        Objectx c = new Objectx("C");
        
        new Thread(new MyThreadPrinter("A", c, a)).start();
        Thread.sleep(10);
        new Thread(new MyThreadPrinter("B", a, b)).start();
        Thread.sleep(10);
        new Thread(new MyThreadPrinter("C", b, c)).start();
        Thread.sleep(10);
    }
}

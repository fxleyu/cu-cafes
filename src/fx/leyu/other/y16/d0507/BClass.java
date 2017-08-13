package fx.leyu.other.y16.d0507;

public class BClass {
    public static synchronized void print() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out.println("BClass start");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("BClass end");
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Runnable() {
            @Override
            public void run() {
                AClass.print();
            }
        });
        d.start();

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                print();
            }
        });
        a.start();
        d.join();
        System.out.println("Game over");
    }
}

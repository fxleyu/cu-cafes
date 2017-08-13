package fx.leyu.other.y16.d0507;

public class AClass {
    public static synchronized void print() {
        System.out.println("AClass start");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("AClass end");
    }
}

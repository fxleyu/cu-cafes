package fx.leyu.leetcode.thread.problem1115;

/**
 * @author fxleyu
 */
public class Main {
    public static void main(String[] args) {

        FooBar fooBar = new FooBar(10);
        new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

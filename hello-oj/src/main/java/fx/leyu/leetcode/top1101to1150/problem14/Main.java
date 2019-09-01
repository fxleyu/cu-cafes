package fx.leyu.leetcode.top1101to1150.problem14;

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(() -> {
            try {
                foo.first(() -> System.out.print("one"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.print("three"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.print("two"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}

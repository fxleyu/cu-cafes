package fx.leyu.jvm.classloading;

public class ConstClass {
    static {
        System.out.println("ConstClass Init!");
    }

    public static final String HELLO_WORLD = "hello world";
}

package fx.leyu.jdk.lang;

public class ThreadDemo {

    public static void handleRunnable() {
        Runnable runnable = () -> System.out.print("Hello world!");
        new Thread(runnable).start();
    }

    public static void handleThreadState() {
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }
    }

    public static void main(String[] args) {
        handleRunnable();
        handleThreadState();
    }
}

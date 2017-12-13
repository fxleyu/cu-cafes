package fx.leyu.jdk.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExcutorTest {

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(2);
    }

}

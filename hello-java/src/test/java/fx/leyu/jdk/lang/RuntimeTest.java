package fx.leyu.jdk.lang;

import org.junit.Test;

public class RuntimeTest {
    @Test
    public void test() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
    }
}

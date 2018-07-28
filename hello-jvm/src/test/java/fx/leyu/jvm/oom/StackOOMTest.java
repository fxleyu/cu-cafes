package fx.leyu.jvm.oom;

import org.junit.Test;

public class StackOOMTest {

    @Test
    public void testStackLeakByThread() {
        while (true) {
            new Thread(() -> {
                while (true) {
                }
            }).start();
        }
    }
}

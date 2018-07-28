package fx.leyu.jdk.lang.ref;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WeakReferenceTest {
    private static final int _1_MB = 1 * 1024 * 1024;
    @Test(expected = OutOfMemoryError.class)
    public void test() throws InterruptedException {
        WeakReference<List<char[]>> weakReference = new WeakReference<>(Lists.newArrayList());
        for (int i = 0; i < 10000; i++) {
            weakReference.get().add(new char[_1_MB]);
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("i = " + i + "; size = " + weakReference.get().size());
        }
    }
}

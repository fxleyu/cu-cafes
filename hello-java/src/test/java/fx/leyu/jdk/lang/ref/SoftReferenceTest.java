package fx.leyu.jdk.lang.ref;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.lang.ref.SoftReference;
import java.util.List;

public class SoftReferenceTest {
    private static final int _512_KB = 1 * 1024 * 512;
    //-XX:+HeapDumpOnOutOfMemoryError -Xmx20m -Xms20m -XX:+PrintGCDetails
    @Test(expected = NullPointerException.class)
    public void testOne() {
        SoftReference<List<char[]>>[] holder = new SoftReference[2];
        holder[0] = new SoftReference<>(Lists.newArrayList());
        holder[1] = new SoftReference<>(Lists.newArrayList());

        for (int i = 0; i < 20; i++) {
            holder[i%2].get().add(new char[_512_KB]);
            System.out.println("i = " + i + "; X size = " + holder[0].get().size());
            System.out.println("i = " + i + "; Y size = " + holder[1].get().size());
        }
    }
}

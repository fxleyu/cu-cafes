package fx.leyu.jdk.lang.ref;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

public class WeakReferenceTest {
    private static final int _512_KB = 1 * 1024 * 512;
    //-XX:+HeapDumpOnOutOfMemoryError -Xmx20m -Xms20m -XX:+PrintGCDetails
    @Test(expected = NullPointerException.class)
    public void test() {
        WeakReference<List<char[]>>[] holder = new WeakReference[2];
        holder[0] = new WeakReference<>(Lists.newArrayList());
        holder[1] = new WeakReference<>(Lists.newArrayList());

        for (int i = 0; i < 10000; i++) {
            holder[i%2].get().add(new char[_512_KB]);
            printInfo(i, holder);
        }
    }

    private void printInfo(int i, Reference<List<char[]>>[] holder) {
        System.out.println("i = " + i + "; X size = " + holder[0].get().size());
        System.out.println("i = " + i + "; Y size = " + holder[1].get().size());
    }
}

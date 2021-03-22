package fx.leyu.jdk.lang.ref;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    //-XX:+HeapDumpOnOutOfMemoryError -Xmx20m -Xms20m -XX:+PrintGCDetails
    @Test(expected = NullPointerException.class)
    public void testOther() {
        WeakReference<List<char[]>>[] holder = new WeakReference[2];
        holder[0] = new WeakReference<>(Lists.newArrayList());
        holder[1] = new WeakReference<>(Lists.newArrayList());

        for (int i = 0; i < 10000; i++) {
            holder[i%2].get().add(new char[_512_KB]);
            System.out.println("i = " + i + "; X size = " + holder[0].get().size());
            System.out.println("i = " + i + "; Y size = " + holder[1].get().size());
        }
    }

    //-XX:+HeapDumpOnOutOfMemoryError -Xmx20m -Xms20m -XX:+PrintGCDetails
    @Test(expected = OutOfMemoryError.class)
    public void testOne() {
        WeakReference<List<char[]>> holder = new WeakReference<>(Lists.newLinkedList());

        for (int i = 0; i < 20; i++) {
            holder.get().add(new char[_512_KB]);
            System.out.println("i = " + i + "; size = " + holder.get().size());
        }
    }

    //-XX:+HeapDumpOnOutOfMemoryError -Xmx20m -Xms20m -XX:+PrintGCDetails
    @Test
    public void testTwo() {
        WeakReference<List<char[]>> holder1 = new WeakReference<>(Lists.newLinkedList());
        WeakReference<List<char[]>> holder2 = new WeakReference<>(Lists.newLinkedList());

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 1) {
                Optional.ofNullable(holder1.get()).ifPresent(list -> list.add(new char[_512_KB]));
                System.out.println("i = " + i + "; size = " + CollectionUtils.size(holder1.get()));
            } else {
                Optional.ofNullable(holder2.get()).ifPresent(list -> list.add(new char[_512_KB]));
                System.out.println("i = " + i + "; size = " + CollectionUtils.size(holder2.get()));
            }
        }
    }
}

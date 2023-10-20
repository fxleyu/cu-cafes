package fx.leyu.jdk.lang.ref;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Optional;

public class ExtendsWeakReferenceTest {
    private static final int _512_KB = 1 * 1024 * 512;

    //-XX:+HeapDumpOnOutOfMemoryError -Xmx20m -Xms20m -XX:+PrintGCDetails
    @Test(expected = OutOfMemoryError.class)
    public void test() {
        Entry holder1 = new Entry(Lists.newLinkedList());
        Entry holder2 = new Entry(Lists.newLinkedList());

        for (int i = 0; i < 20000; i++) {
            if (i % 2 == 1) {
                holder1.setValue(new char[_512_KB / 10]);
                Optional.ofNullable(holder1.get()).ifPresent(list -> list.add(new char[_512_KB]));
                System.out.println("i = " + i + "; size = " + CollectionUtils.size(holder1.get()));
                System.out.println("i = " + i + "; Vsize = " + CollectionUtils.size(holder1.getValue()));
            } else {
                holder2.setValue(new char[_512_KB / 10]);
                Optional.ofNullable(holder2.get()).ifPresent(list -> list.add(new char[_512_KB]));
                System.out.println("i = " + i + "; size = " + CollectionUtils.size(holder2.get()));
                System.out.println("i = " + i + "; Vsize = " + CollectionUtils.size(holder2.getValue()));

            }
            System.out.println();
        }
    }
    public static class Entry extends WeakReference<List<char[]>> {
        /** The value associated with this ThreadLocal. */
        List<char[]> value;

        Entry(List<char[]> v) {
            super(v);
            value = Lists.newLinkedList();
        }

        public List<char[]> getValue() {
            return value;
        }

        public void setValue(char[] value) {
            this.value.add(value);
        }
    }
}

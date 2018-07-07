package fx.leyu.jdk.util;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

public class WeakHashMapTest {
    private static Map<String, String> map = new WeakHashMap<>();
    private static Set<String> set = Collections.newSetFromMap(new WeakHashMap<String, Boolean>());

    private static final int MAX = 1000000;
    private static List<String> list = Lists.newArrayListWithCapacity(MAX);

    @BeforeClass
    public static void beforeClass() {
        for (int i = 0; i < MAX; i++) {
            list.add(RandomUtils.nextInt(0, i), "test" + 1);
        }
    }

    @Test
    public void testMap() {
        long start = System.currentTimeMillis();
        for (String key : list) {
            map.put(key, null);
        }
        long now = System.currentTimeMillis();
        System.out.println("MAP PUT = " + (now - start));

        start = System.currentTimeMillis();
        for (String key : list) {
            map.remove(key);
        }
        now = System.currentTimeMillis();
        System.out.println("MAP REMOVE = " + (now - start));
    }

    @Test
    public void testSet() {
        long start = System.currentTimeMillis();
        for (String key : list) {
            set.add(key);
        }
        long now = System.currentTimeMillis();
        System.out.println("SET ADD = " + (now - start));

        start = System.currentTimeMillis();
        for (String key : list) {
            set.remove(key);
        }
        now = System.currentTimeMillis();
        System.out.println("SET REMOVE = " + (now - start));
    }
}

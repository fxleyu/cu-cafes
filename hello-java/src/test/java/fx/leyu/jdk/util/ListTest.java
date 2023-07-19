package fx.leyu.jdk.util;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class ListTest {
    @Test
    public void testEmpty4ForEach() {
        List<Integer> list = Collections.emptyList();
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}

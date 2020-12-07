package fx.leyu.jdk.util;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.ListUtils;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

public class ListUtilsTest {
    @Test
    public void test() {
        List<Integer> list = Lists.newArrayList(0, 2, 2, 4, 4, 6, 8);
        list = ListUtils.predicatedList(list, x -> x % 2 == 0);
        System.out.println(list);
    }
}

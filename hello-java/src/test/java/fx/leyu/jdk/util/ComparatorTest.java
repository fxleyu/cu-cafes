package fx.leyu.jdk.util;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ComparatorTest {
    @Test
    public void test() {
        List<List<Integer>> listArray = Lists.newArrayList(Lists.newArrayList(1,2,4),
                Lists.newArrayList(4,2,4),
                Lists.newArrayList(23,4,2,4),
                Lists.newArrayList(2),
                Lists.newArrayList());
        listArray.sort((x,y) -> count(y) - count(x));
        for (List<Integer> integers : listArray) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }

    private Integer count(List<Integer> x) {
        int result = 0;
        if (CollectionUtils.isEmpty(x)) {
            return result;
        }

        for (Integer integer : x) {
            if (Objects.nonNull(integer)) {
                result += integer;
            }
        }
        return result;
    }
}

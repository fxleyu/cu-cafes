package fx.leyu.jdk.util;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.ListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListTest {
    @Test
    public void testEmpty4ForEach() {
        List<String> list = Collections.emptyList();
        for (String str : list) {
            System.out.println(str);
        }
        Assert.assertNotNull(list);
    }

    @Test
    public void testString() {
        List<String> strList = Lists.newArrayList("A", "B", null, null, "C", "D");
        List<Integer> sizeList = strList.stream()
                .filter(Objects::nonNull)
                .map(String::length)
                .collect(Collectors.toList());
        Assert.assertEquals(4, sizeList.size());
    }
}

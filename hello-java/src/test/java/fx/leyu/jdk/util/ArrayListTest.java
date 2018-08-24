package fx.leyu.jdk.util;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class ArrayListTest {
    @Test
    public void testPartition() {
        List<Integer> bigList = Lists.newArrayList();
        List<List<Integer>> smallLists = Lists.newArrayList();
        List<List<Integer>> newSmallLists = ListUtils.partition(bigList, 10);

        for (int i = 0; i < 98; i++) {
            bigList.add(i);
            if (i < 10) {
                smallLists.add(Lists.newArrayList());
            }
            smallLists.get(i / 10).add(i);
        }
        for (int i = 0; i < newSmallLists.size(); i++) {
            Assert.assertTrue(CollectionUtils.isEqualCollection(newSmallLists.get(i), smallLists.get(i)));
        }
    }
}

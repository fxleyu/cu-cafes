package fx.leyu.jdk.util;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

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

    @Test
    public void test() {
        ArrayList<Integer> listA = Lists.newArrayList();
        Stream<Integer> streamA = listA.parallelStream();
        streamA.count();

        List<Integer> listB = Lists.newArrayList();
        Stream<Integer> streamB = listB.stream();
    }

    @Test
    public void testRemove() {
        ArrayList<Integer> listA = Lists.newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        listA.removeIf(x -> x % 2 == 0);
        System.out.println(listA);
    }
}

package fx.leyu.jdk.util;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.ComparatorUtils;
import org.apache.commons.collections4.MapUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MapTest {

    @Test
    public void testGetNullValue() {
        Map<String, String> map = Maps.newHashMap();
        String key = "key";
        String value = "value";
        Assert.assertEquals(map.getOrDefault(key, value), value);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void test() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (Objects.equals(entry.getKey(), "1")) {
                map.remove("1");
            }
        }
        Assert.assertEquals(1, MapUtils.size(map));
    }

    @Test
    public void testWithoutException() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.entrySet().removeIf(stringStringEntry -> Objects.equals(stringStringEntry.getKey(), "1"));
        Assert.assertEquals(1, MapUtils.size(map));
    }

    @Test
    public void testMapValue() {
        String value = "value_before";
        Map<String, String> map = new HashMap<>();
        map.put("1", value);
        value = "value_after";
        System.out.println(map.get("1"));
        System.out.println(value);
        Assert.assertEquals(1, MapUtils.size(map));
    }

    @Test
    public void sort() {
        String value = "value_before";
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        map.put("11", 11);
        map.put("12", 12);

        List<Map.Entry<String, Integer>> list = Lists.newArrayList(map.entrySet());
        System.out.println("start " + JSONObject.toJSONString(list));
        list.sort(ComparatorUtils.reversedComparator(Map.Entry.comparingByValue()));
        System.out.println("sort " + JSONObject.toJSONString(list));

        value = "value_after";
        System.out.println(map.get("1"));
        System.out.println(value);
        //Assert.assertEquals(1, MapUtils.size(map));

        int MAX_LOOP_COUNT = 2_0000;
        System.out.println("MAX_LOOP_COUNT > " + MAX_LOOP_COUNT);
    }
}

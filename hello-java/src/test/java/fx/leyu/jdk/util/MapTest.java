package fx.leyu.jdk.util;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.ComparatorUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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

        String x = "\uD835\uDE8C \uD835\uDE91\uD835\uDE8A\uD835\uDE96\uD835\uDE99\uD835\uDE8A \uD835\uDE97\uD835\uDE8A\uD835\uDE90\uD835\uDE8A\uD835\uDE9B,\uD835\uDE71\uD835\uDE92\uD835\uDE9C\uD835\uDE91\uD835\uDE8A\uD835\uDE9B\uD835\uDE92 \uD835\uDE8A\uD835\uDE9C\uD835\uDE9D\uD835\uDE8A\uD835\uDE97, \uD835\uDE9A\uD835\uDE9E\uD835\uDE9C\uD835\uDE8B\uD835\uDE8A, \uD835\uDE90\uD835\uDE98\uD835\uDE95\uD835\uDE8F\uD835\uDE8E\uD835\uDE97 \uD835\uDE96\uD835\uDE8E\uD835\uDE8D\uD835\uDE92\uD835\uDE8C\uD835\uDE8A\uD835\uDE95 \uD835\uDE91\uD835\uDE8A\uD835\uDE95\uD835\uDE95";
        System.out.println(x);
        System.out.println(StringUtils.substringBeforeLast("https://www.instagram.com/anavikalia?ddd", "?"));
        System.out.println(StringUtils.contains("https://www.instagram.com/anavikalia?ddd", "?"));
        System.out.println(StringUtils.uncapitalize(x));
        //StringUtils.uncapitalize()
        System.out.println(RandomStringUtils.randomAlphanumeric(8));
    }
}

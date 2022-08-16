package fx.leyu.jdk.util;

import com.google.common.collect.Maps;
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
}

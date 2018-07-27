package fx.leyu.jdk.util;

import com.google.common.collect.Maps;
import org.apache.commons.collections4.MapUtils;
import org.junit.Test;

import java.util.TreeMap;

public class TreeMapTest {

    @Test(expected = NullPointerException.class)
    public void testGetByNullKey() {
        TreeMap<String, String> treeMap = Maps.newTreeMap();
        treeMap.get(null);
    }

    @Test(expected = NullPointerException.class)
    public void testGetByNullKeyWithMapUtils() {
        TreeMap<String, String> treeMap = Maps.newTreeMap();
        MapUtils.getString(treeMap, null);
    }
}

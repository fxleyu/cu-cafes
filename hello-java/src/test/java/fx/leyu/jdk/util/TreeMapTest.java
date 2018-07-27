package fx.leyu.jdk.util;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.TreeMap;

public class TreeMapTest {

    @Test(expected=NullPointerException.class)
    public void testGetByNullKey() {
        TreeMap<String, String> treeMap = Maps.newTreeMap();
        treeMap.get(null);
    }
}

package fx.leyu.jdk.util;

import com.google.common.collect.Maps;
import org.apache.commons.collections4.MapUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class HashMapTest {
    private static final String NULL_KEY = null;
    private static final String VALUE = "NULL KEY VALUE";

    @Test
    public void testGetByNullKey() {
        HashMap<String, String> hashMap = Maps.newHashMap();
        hashMap.put(NULL_KEY, VALUE);

        Assert.assertEquals(VALUE, hashMap.get(NULL_KEY));
        Assert.assertEquals(hashMap.get(NULL_KEY), MapUtils.getString(hashMap, NULL_KEY));
    }

    @Test
    public void testContainsByNullKey() {
        HashMap<String, String> hashMap = Maps.newHashMap();
        hashMap.put(NULL_KEY, VALUE);
        Assert.assertTrue(hashMap.containsKey(NULL_KEY));
    }
}

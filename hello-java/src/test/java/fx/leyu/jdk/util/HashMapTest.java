package fx.leyu.jdk.util;

import com.google.common.collect.Maps;
import org.apache.commons.collections4.MapUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class HashMapTest {
    @Test
    public void testGetByNullKey() {
        final String nullKey = null;
        final String value = "NULL KEY VALUE";

        HashMap<String, String> hashMap = Maps.newHashMap();
        hashMap.put(nullKey, value);

        Assert.assertEquals(value, hashMap.get(nullKey));
        Assert.assertEquals(hashMap.get(nullKey), MapUtils.getString(hashMap, nullKey));
    }
}

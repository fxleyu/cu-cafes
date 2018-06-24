package fx.leyu.jdk.util;

import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class MapTest {

    @Test
    public void testGetNullValue() {
        Map<String, String> map = Maps.newHashMap();
        String key = "key";
        String value = "value";
        Assert.assertEquals(map.getOrDefault(key, value), value);
    }
}

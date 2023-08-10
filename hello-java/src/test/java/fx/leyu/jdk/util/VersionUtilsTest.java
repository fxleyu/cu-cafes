package fx.leyu.jdk.util;

import org.junit.Assert;
import org.junit.Test;

public class VersionUtilsTest {
    @Test
    public void testVersion() {
        Assert.assertTrue(VersionUtils.aBiggerThanB("7.0", "6.90.1.1"));
        Assert.assertFalse(VersionUtils.aBiggerThanB("7.0", "7.0"));
    }
}

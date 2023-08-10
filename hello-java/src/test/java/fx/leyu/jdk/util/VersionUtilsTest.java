package fx.leyu.jdk.util;

import org.junit.Assert;
import org.junit.Test;

public class VersionUtilsTest {
    @Test
    public void testVersion() {
        Assert.assertFalse(VersionUtils.aBiggerThanB("6.1000.1.1", "7.90.1"));
        Assert.assertFalse(VersionUtils.aBiggerThanB("7.0", "7.0"));
    }
}

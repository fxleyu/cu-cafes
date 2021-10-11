package fx.leyu.jdk.lang;

import org.junit.Assert;
import org.junit.Test;

public class ClassTypeTest {
    @Test
    public void test() {
        Object string = "string";
        Assert.assertTrue(string instanceof Object);
        Assert.assertTrue(string instanceof String);

        Object nullObject = null;
        Assert.assertFalse(nullObject instanceof  Object);
    }
}

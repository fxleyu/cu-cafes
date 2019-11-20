package fx.leyu.jdk.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;
import java.util.Optional;

public class OptionalTest {

    @Test
    public void testMap() {
        Integer length = Optional.ofNullable("String").map(String::length).get();
        Assert.assertEquals("6", length.toString());
    }

    @Test
    public void test() {
        String string = Optional.ofNullable("null").filter(Objects::isNull).orElse(null);
        Assert.assertNull(string);
    }
}

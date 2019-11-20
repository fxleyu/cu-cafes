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
    public void testFilter() {
        String string = Optional.ofNullable("null").filter(Objects::isNull).orElse(null);
        Assert.assertNull(string);
    }

    @Test(expected = NullPointerException.class)
    public void testThrow() {
        String string = Optional.ofNullable("null").filter(Objects::isNull).orElseThrow(NullPointerException::new);
    }
}

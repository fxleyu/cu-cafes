package fx.leyu.jdk.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.StringJoiner;

public class StringJoinerTest {
    @Test
    public void testAdd() {
        StringJoiner joiner = new StringJoiner(",");
        joiner.add("123").add("345");
        Assert.assertEquals("123,345", joiner.toString());
    }

    @Test
    public void testAddWithPrefix() {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        joiner.add("123").add("345");
        Assert.assertEquals("[123,345]", joiner.toString());
    }
}

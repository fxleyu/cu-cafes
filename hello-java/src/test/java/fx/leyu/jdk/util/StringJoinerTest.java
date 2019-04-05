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

    @Test
    public void testNull() {
        StringJoiner joiner = new StringJoiner(",");
        Assert.assertEquals("", joiner.toString());

        joiner = new StringJoiner(",", "[", "]");
        Assert.assertEquals("[]", joiner.toString());
    }

    @Test
    public void testMerge() {
        StringJoiner one = new StringJoiner(":", "[", "]");
        StringJoiner two = new StringJoiner("#", "<", ">");
        one.add("123").add("345");
        two.add("123").add("345");
        Assert.assertEquals("[123:345:123#345]", one.merge(two).toString());
    }
}

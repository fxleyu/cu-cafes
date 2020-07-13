package fx.leyu.jdk.util;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

public class StreamTest {

    @Test
    public void test() {
        List<Integer> list = Lists.newArrayList(1, null, 2, 3);
        Assert.assertEquals(1, list.stream().filter(Objects::isNull).count());
        Assert.assertEquals(1, list.stream().filter(Objects::nonNull).count());
    }
}

package fx.leyu.jdk8;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    public void testFilter() {
        List<String> beginningWithNumber = Lists.newArrayList();
        for (String value : Arrays.asList("a", "1abc", "abc1")) {
            if (Character.isDigit(value.charAt(0))) {
                beginningWithNumber.add(value);
            }
        }

        Assert.assertEquals(Arrays.asList("1abc"), beginningWithNumber);
    }

    @Test
    public void testFilterByStream() {
        List<String> beginningWitheNumber = Stream.of("a", "1abc", "abc1")
                .filter(str -> Character.isDigit(str.charAt(0)))
                .collect(Collectors.toList()) ;
        Assert.assertEquals(Arrays.asList("1abc"), beginningWitheNumber);
    }
}

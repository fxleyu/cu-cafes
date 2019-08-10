package fx.leyu.jdk.function;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class StreamTest {
    @Test(expected = IllegalStateException.class)
    public void test() {
        List<String> list = Lists.newArrayList("a", "abc", "ac", "abcd", "a");
        Stream<String> stream = list.stream().filter(Objects::nonNull).filter(s -> s.length() > 1);
        System.out.println("start");
        System.out.println("stream find first "+ stream.findFirst().orElse("null"));

        //java.lang.IllegalStateException: stream has already been operated upon or closed
        System.out.println("stream length "+ stream.count());
    }
}

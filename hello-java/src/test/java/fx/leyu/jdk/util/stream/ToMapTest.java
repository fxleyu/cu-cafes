package fx.leyu.jdk.util.stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToMapTest {
    public static class Name {
        String string;

        public Name(String string) {
            this.string = string;
        }
        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }
    }

    @Test
    public void test() {
        List<Name> list = Lists.newArrayList(new Name("fxleyu"), new Name(null), new Name("fxuyer"));
        Map<Integer, String> map = list.stream()
                .collect(Collectors.toMap(Name::hashCode, Name::getString));

        boolean x = ((Integer)null == 1);
    }
}

package fx.leyu.jdk.lang;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OptionalTest {
    private static Map<String, String> map = Objects.requireNonNull(new HashMap<>());
    @Test
    public void test() {
        if (map != null) {
            
        }

    }
}

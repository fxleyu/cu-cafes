package fx.leyu.jdk.lang;

import org.junit.Test;

public class ArrayTest {
    @Test
    public void test() {
        String[] strings = new String[2];
        Object[] objects = strings;
        objects[0] = "string";
        objects[1] = 1;
    }
}

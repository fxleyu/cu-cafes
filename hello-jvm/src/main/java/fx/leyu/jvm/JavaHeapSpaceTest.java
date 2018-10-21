package fx.leyu.jvm;

import java.util.ArrayList;
import java.util.List;
// -XX:+HeapDumpOnOutOfMemoryError -Xmx20m -Xms20m
public class JavaHeapSpaceTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true) {
            list.add("Hello world");
        }
    }
}

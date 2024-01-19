package fx.leyu.jdk.lang;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

public class BucketUnevenTest {
    @Test
    public void testHashCode() {
        List<String> list = Lists.newArrayList(
                "8575202086", "9980640115", "9108574507","7619392223", "9026564805", "7724852999", "6303148569",
                "7719497748", "9075516744");
        list.stream().map(String::hashCode).map(x -> x % 100).forEach(System.out::println);
    }

    @Test
    public void testList() {
        int x = -2147483648;
        long y = x;

        System.out.println(Math.abs(y));
    }
}

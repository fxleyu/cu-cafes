package fx.leyu.jdk.lang;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BucketUnevenTest {
    @Test
    public void testHashCode() {
        List<String> list = Lists.newArrayList(
                "8575202086", "9980640115", "9108574507","7619392223", "9026564805", "7724852999", "6303148569",
                "7719497748", "9075516744");
        list.stream().map(String::hashCode).map(x -> x % 100).forEach(System.out::println);

        int hash = "+91".hashCode();
        System.out.println(hash % 100);
    }

    @Test
    public void testList() {
        int x = -2147483648;
        long y = x;

        System.out.println(Math.abs(y));
    }

    @Test()
    public void test() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");

        for (int i = 0; i < 100; i++) {
            for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                System.out.print(stringStringEntry.getKey() + "x ");
            }
            System.out.println();
        }

    }
}

package fx.leyu.jdk.lang;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    @Test
    public void test() throws InterruptedException {
        List<String> string = Lists.newArrayListWithCapacity(600);
        for (int i = 0; i < 90000; i++) {
            string.add(String.valueOf(RandomUtils.nextInt(100000, 200000000)));
        }

        //TimeUnit.SECONDS.sleep(10);
        long start = System.currentTimeMillis();
        for (int i =0; i < 10000; i++) {
            List<String> strings = string.stream()
                    .map(x -> String.valueOf(x.length()))
                    .collect(Collectors.toList());
        }
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (int i =0; i < 10000; i++) {
            List<String> stringsArr = Lists.newArrayList();
            for (String s : string) {
                stringsArr.add(String.valueOf(s.length()));
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}

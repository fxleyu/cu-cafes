package fx.leyu.jdk.util;

import com.google.common.collect.Sets;
import org.apache.commons.collections4.SetUtils;
import org.junit.Test;

import java.util.Set;

public class SetUtilsTest {

    @Test
    public void testDifference() {
        Set<String> set4ABC = Sets.newHashSet("A", "B", "C");
        Set<String> set4CDE = Sets.newHashSet("C", "D", "E");

        SetUtils.SetView<String> minus = SetUtils.difference(set4ABC, set4CDE);
        for (String s : minus) {
            // A B
            System.out.println(s);
        }
    }
}

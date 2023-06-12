package fx.leyu.jdk.lang;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtilsTest {
    @Test
    public void test() {
        // {23,12}
        System.out.println(ArrayUtils.toString(StringUtils.split("23,12", ",")));
        // {23}
        System.out.println(ArrayUtils.toString(StringUtils.split("23", ",")));
        // {}
        System.out.println(ArrayUtils.toString(StringUtils.split("", ",")));

    }
}

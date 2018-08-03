package fx.leyu.jdk.util;

import org.junit.Assert;
import org.junit.Test;

public class ExceptionTest {

    @Test
    public void testLine() {
        String str = "";
        String string = null;
        if (str.length() == 0
                && string.length() == str.length()) {
            Assert.assertEquals(str, string);
        }
    }
}

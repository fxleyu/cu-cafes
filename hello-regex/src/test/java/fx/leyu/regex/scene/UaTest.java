package fx.leyu.regex.scene;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fxleyu
 */
public class UaTest {
    @Test
    public void testAppVersion() {
        String ua = "xxx Fxleyu/12.1.2";
        Pattern pattern = Pattern.compile("fxleyu/([.\\d]+)");
        Matcher matcher = pattern.matcher(ua.toLowerCase());
        if (matcher.find()) {
            System.out.print(matcher.group(1));
        }
    }
}

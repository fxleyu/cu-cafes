package fx.leyu.regex.business;

import org.junit.Assert;
import org.junit.Test;

public class UrlTest {

    @Test
    public void testRemoveScheme() {
        String httpUrl = "http://en.wikipedia.org/wiki/URL";
        String httpsUrl = "https://en.wikipedia.org/wiki/URL";
        String urlWithoutScheme = "//en.wikipedia.org/wiki/URL";

        String regex = "https?:";
        Assert.assertEquals(urlWithoutScheme, httpUrl.replaceAll(regex, ""));
        Assert.assertEquals(urlWithoutScheme, httpsUrl.replaceAll(regex, ""));
    }
}

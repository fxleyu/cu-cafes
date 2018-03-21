package fx.leyu;

import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

public class CharacterCodeTest {
    private static final String GBK = "GBK";
    private static final String ISO_8859_1 = "ISO_8859_1";
    
    private static final String TEST_STRING = "风雪乐雨";
    
    @Test
    public void testGbkTo8859() throws UnsupportedEncodingException {
        byte[] byteArray = TEST_STRING.getBytes(GBK);
        // 打印8个字符
        System.out.println(new String(byteArray, ISO_8859_1));
    }
    
    @Test
    public void test8859To8859() throws UnsupportedEncodingException {
        byte[] byteArray = TEST_STRING.getBytes(ISO_8859_1);
        // 打印4个?字符
        Assert.assertEquals("\"风雪乐雨\".getBytes(ISO_8859_1).length == 4", 4, byteArray.length);
        Assert.assertEquals("4个汉字转换为8859，再转换为string是?", "????", new String(byteArray, ISO_8859_1));
    }

}

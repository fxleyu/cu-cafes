package fx.leyu.interview.ant;

import org.junit.Assert;
import org.junit.Test;

public class IpLibTest {
    @Test
    public void test() {
        String[] input = {
                "10.0.0.1~10.0.0.100",
                "10.0.0.101~10.0.0.255",
                "192.168.0.1~192.168.0.255",
                "62.0.0.1~62.0.0.255",
                "255.255.255.0~255.255.255.255"};
        IpLib.createIpLib(input);
        Assert.assertEquals("10.0.0.1~10.0.0.100", IpLib.gainConfig("10.0.0.10"));
        Assert.assertNull(IpLib.gainConfig("67.0.0.1"));
    }
}

package fx.leyu.interview.ant;

import org.junit.Assert;
import org.junit.Test;

public class IpSetTest {
    @Test
    public void test() {
        long start = IpSet.getIp("10.10.1.1");
        long end = IpSet.getIp("10.10.2.1");
        for (; start <= end; start = start + 1) {
            IpSet.update(start);
        }
        Assert.assertTrue(IpSet.contains(IpSet.getIp("10.10.1.255")));
        Assert.assertTrue(IpSet.contains(IpSet.getIp("10.10.1.1")));
        Assert.assertTrue(IpSet.contains(IpSet.getIp("10.10.2.1")));
        Assert.assertFalse(IpSet.contains(IpSet.getIp("10.10.2.2")));
        Assert.assertFalse(IpSet.contains(IpSet.getIp("10.10.1.0")));

        Assert.assertFalse(IpSet.contains(IpSet.getIp("255.10.232.255")));

        start = IpSet.getIp("255.10.1.1");
        end = IpSet.getIp("255.10.2.1");
        for (; start <= end; start = start + 1) {
            IpSet.update(start);
        }

        Assert.assertTrue(IpSet.contains(IpSet.getIp("255.10.1.255")));
        Assert.assertTrue(IpSet.contains(IpSet.getIp("255.10.1.1")));
        Assert.assertTrue(IpSet.contains(IpSet.getIp("255.10.2.1")));
        Assert.assertFalse(IpSet.contains(IpSet.getIp("255.10.2.2")));
        Assert.assertFalse(IpSet.contains(IpSet.getIp("255.10.1.0")));

        Assert.assertFalse(IpSet.contains(IpSet.getIp("255.10.232.255")));
    }
}

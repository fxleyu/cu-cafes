package fx.leyu.interview.ant;

import java.math.BigInteger;

public class IpSet {
    private static BigInteger bigSet = new BigInteger("0");
    private static BigInteger smallSet = new BigInteger("0");

    public static synchronized void update(long ip) {
        if (ip > Integer.MAX_VALUE) {
            ip = ip - Integer.MAX_VALUE - 1;
            bigSet = bigSet.setBit((int)ip);
        } else {
            smallSet = smallSet.setBit((int)ip);
        }
    }

    public static long getIp(String ip) {
        String[] ips = ip.split("\\.");
        if (ips.length != 4) {
            throw new IllegalArgumentException("invalid ip " + ip);
        }
        long result = 0;
        for (int i = 0; i < 4; i++) {
            int num = Integer.valueOf(ips[i]);
            if (num < 0 || num > 255) {
                throw new IllegalArgumentException("invalid ip " + ip);
            }
            result = result + (long)(num * Math.pow(256, 3 - i));
        }
        return result;
    }

    public static synchronized boolean contains(long ip) {
        if (ip > Integer.MAX_VALUE) {
            ip = ip - Integer.MAX_VALUE - 1;
            return bigSet.testBit((int)ip);
        } else {
            return smallSet.testBit((int)ip);
        }
    }
}

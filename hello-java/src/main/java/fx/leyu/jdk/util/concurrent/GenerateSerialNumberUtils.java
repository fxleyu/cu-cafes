package fx.leyu.jdk.util.concurrent;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author fxleyu
 */
public class GenerateSerialNumberUtils {
    private static volatile int nexSerialNumber = 0;
    private static final AtomicLong NEX_SERIAL_NUMBER_FOR_ATOMIC = new AtomicLong();

    /**
     * 有问题：
     * `++`不是原子操作。故其导致安全性失败（safety failure）
     */
    public static int generateSerialNumber() {
        return nexSerialNumber++;
    }

    public static long generateSerialNumberForAtomic() {
        return NEX_SERIAL_NUMBER_FOR_ATOMIC.getAndIncrement();
    }
}

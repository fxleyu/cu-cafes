package fx.leyu.effective.concurrent;

import java.util.concurrent.atomic.AtomicLong;

public class GenerateSerialNumberUtils {
    private static volatile int nexSerialNumber = 0;
    private static final AtomicLong nexSerialNumberForAtomic = new AtomicLong();
    
    /*
     * 有问题：
     * `++`不是原子操作。故其导致安全性失败（safety failure）
     */
    public static int generateSerialNumber() {
        return nexSerialNumber++;
    }
    
    public static long generateSerialNumberForAtomic() {
        return nexSerialNumberForAtomic.getAndIncrement();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

}

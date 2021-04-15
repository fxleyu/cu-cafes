package fx.leyu.jdk.util;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.*;

/**
 * @author fxleyu
 */
public class ThreadLocalMain {

    public static void main(String[] args) throws InterruptedException {
       ThreadLocal<String> threadLocal = new ThreadLocal<>();
       threadLocal.set("hello World");
       System.gc();
       Thread.sleep(111);
       System.gc();
       System.out.println(threadLocal.get());
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
            for (GarbageCollectorMXBean bean : garbageCollectorMXBeans) {
                System.out.println(bean.getCollectionCount());
                System.out.println(bean.getObjectName());
                System.out.println(bean.getName());
                System.out.println(Arrays.toString(bean.getMemoryPoolNames()));
            }
            list.add("Hello world" + i++);
            System.out.println(threadLocal.get());
        }
    }
}

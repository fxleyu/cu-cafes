package fx.leyu.jdk.lang.management;

import org.junit.Test;

import java.lang.management.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ManagementFactoryTest {

    @Test
    public void testClassLoadingMXBean() throws InterruptedException {
        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        classLoadingMXBean.setVerbose(true);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("LoadedClassCount : " + classLoadingMXBean.getLoadedClassCount());
        System.out.println("TotalLoadedClassCount : " + classLoadingMXBean.getTotalLoadedClassCount());
        System.out.println("UnloadedClassCount : " + classLoadingMXBean.getUnloadedClassCount());
        System.out.println("ObjectName ?: " + classLoadingMXBean.getObjectName());
    }

    @Test
    public void testCompilationMXBean() throws ClassNotFoundException {
        CompilationMXBean compilationMXBean = ManagementFactory.getCompilationMXBean();
        System.out.println(compilationMXBean.getName());
    }

    @Test
    public void testGarbageCollectorMXBeans() {
        List<GarbageCollectorMXBean> garbageCollectorList = ManagementFactory.getGarbageCollectorMXBeans();
        garbageCollectorList.forEach(garbageCollectorMXBean -> System.out.println(garbageCollectorMXBean.getName()));
    }

    @Test
    public void testMemoryManagerMXBeans() {
        List<MemoryManagerMXBean> memoryManagerMXBeanList = ManagementFactory.getMemoryManagerMXBeans();
        memoryManagerMXBeanList.forEach(bean -> {
            System.out.println(bean.getName() + " : " + Arrays.toString(bean.getMemoryPoolNames()));
        });
    }

    @Test
    public void testAllThreadIds() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.getAllThreadIds();
        for (long threadId : threadIds) {
            System.out.println(threadMXBean.getThreadInfo(threadId));
        }
    }

    @Test
    public void testMemoryMXBean() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        System.out.println("HeapMemoryUsage : " + memoryMXBean.getHeapMemoryUsage());
        System.out.println("NonHeapMemoryUsage : " + memoryMXBean.getNonHeapMemoryUsage());
        System.out.println("HeapMemoryUsage : " + memoryMXBean.getObjectPendingFinalizationCount());
        System.out.println("ObjectName : " + memoryMXBean.getObjectName());
    }
}

package fx.leyu.jdk.lang.management;

import org.junit.Test;

import java.lang.management.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
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
    public void testCompilationMXBean() {
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
    public void testMemoryMXBean() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        System.out.println("HeapMemoryUsage : " + memoryMXBean.getHeapMemoryUsage());
        System.out.println("NonHeapMemoryUsage : " + memoryMXBean.getNonHeapMemoryUsage());
        System.out.println("HeapMemoryUsage : " + memoryMXBean.getObjectPendingFinalizationCount());
        System.out.println("ObjectName : " + memoryMXBean.getObjectName());
    }

    @Test
    public void testMemoryPoolMXBeans() {
        List<MemoryPoolMXBean> beanList = ManagementFactory.getMemoryPoolMXBeans();
        beanList.forEach(bean -> {
            System.out.println(bean.getName()
                    + "  \n -> manager : " + Arrays.toString(bean.getMemoryManagerNames())
                    + "  \n -> " +  " : " + bean.getCollectionUsage());
        });
    }

    @Test
    public void testOperatingSystemMXBean() {
        OperatingSystemMXBean bean = ManagementFactory.getOperatingSystemMXBean();
        System.out.println(bean.getName() + " : " + bean.getArch());
    }

    @Test
    public void testPlatformManagementInterfaces() {
        Set<Class<? extends PlatformManagedObject>> set = ManagementFactory.getPlatformManagementInterfaces();
        set.forEach(bean -> {
            System.out.println(bean.getCanonicalName());
        });
    }

    @Test
    public void testRuntimeMXBean() {
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        System.out.println(bean.getInputArguments());
    }

    @Test
    public void testThreadMXBean() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.getAllThreadIds();
        for (long threadId : threadIds) {
            System.out.println(threadMXBean.getThreadInfo(threadId));
        }
    }


}

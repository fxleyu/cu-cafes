package fx.leyu.lang.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class MothedTest {
    
    @Test
    public void testCommonMessage() {
        MethodTestClass mts = new MethodTestClass();
        ClassUtils.printClassConstructMessage(mts);
        ClassUtils.printClassFieldMessage(mts);
        ClassUtils.printClassMethodMessage(mts);
    }
    
    @Test
    public void testInvokePublic() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        Class cls = Class.forName("fx.leyu.lang.reflect.MethodTestClass");
        Method method = cls.getMethod("print", int.class, int.class);
        Object obj = method.invoke(cls.newInstance(), new Object[]{1,2});
        System.out.println(obj);
    }
    
    @Test
    public void testInvokePrivate() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        Class cls = Class.forName("fx.leyu.lang.reflect.MethodTestClass");
        Method method = cls.getDeclaredMethod("print", int.class, int.class, int.class);
        method.setAccessible(true);
        Object obj = method.invoke(cls.newInstance(), new Object[]{1,2, 3});
        System.out.println(obj);
    }

}

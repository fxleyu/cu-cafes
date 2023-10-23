package fx.leyu.jdk.lang.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTest {
    
    @Test
    public void testCommonMessage() {
        MethodTestClass mts = new MethodTestClass();
        ClassUtils.printClassConstructMessage(mts);
        ClassUtils.printClassFieldMessage(mts);
        ClassUtils.printClassMethodMessage(mts);
    }
    
    @Test
    public void testInvokePublic() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        Class<?> cls = Class.forName("fx.leyu.jdk.lang.reflect.MethodTestClass");
        Method method = cls.getMethod("print", int.class, int.class);
        Object obj = method.invoke(cls.newInstance(), 1,2);
        System.out.println(obj);
    }
    
    @Test
    public void testInvokePrivate() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        Class<?> cls = Class.forName("fx.leyu.jdk.lang.reflect.MethodTest$MethodClass");
        Method method = cls.getDeclaredMethod("privateMethod");
        method.setAccessible(true);
        Object obj = method.invoke(cls.newInstance());
        System.out.println(obj);
    }

    @Test
    public void test() {
        Class<MethodClass> clazz = MethodClass.class;
        // public
        System.out.println(Arrays.toString(clazz.getMethods()));

        // 声明参数
        System.out.println(Arrays.toString(clazz.getDeclaredMethods()));
    }

    @Test
    public void testInvoke() {
        MethodClass methodClass = new MethodClass();
        Arrays.stream(methodClass.getClass().getDeclaredMethods())
                .forEach(method -> {
                    try {
                        method.setAccessible(true);
                        if (method.getParameterCount() == 0) {
                            System.out.println(method.invoke(methodClass));
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
    }

    public static class MethodClass {
        private String privateMethod() {
            return "privateMethod";
        }

        protected String protectedMethod() {
            return "protectedMethod";
        }

        String defaultMethod() {
            return "defaultMethod";
        }

        public String publicMethod() {
            return "publicMethod";
        }

        public void voidMethod() {
        }
    }
}

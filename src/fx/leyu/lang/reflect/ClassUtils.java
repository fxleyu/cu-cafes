package fx.leyu.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtils {
    public static void printClassMethodMessage(Object obj) {
        Class c = obj.getClass();
        System.out.println(c.getName());
        
        // public methods
        Method[] publicMs = c.getMethods();
        Method[] ms = c.getDeclaredMethods();
        
        for (Method method : ms) {
            System.out.print(method.getModifiers() + " " + method.getReturnType() + " " + method.getName() + " (");
            Class[] paramTypes = method.getParameterTypes();
            for (Class p : paramTypes) {
                System.out.print(p.getName() + " ");
            }
            System.out.println(") ;");
        }
    }
    
    public static void printClassFieldMessage(Object obj) {
        Class c = obj.getClass();
        Field[] fs = c.getDeclaredFields();
        for (Field f : fs) {
            System.out.println(f.getModifiers() + " " + f.getType().getName() + " " + f.getName());
        }
    }
    
    public static void printClassConstructMessage(Object obj) {
        Class c = obj.getClass();
        Constructor[] cs = c.getDeclaredConstructors();
        for (Constructor con : cs) {
            System.out.print(con.getModifiers() + " " + con.getName() + " (");
            Class[] paramTypes = con.getParameterTypes();
            for (Class p : paramTypes) {
                System.out.print(p.getName() + " ");
            }
            System.out.println(") ;");
        }
    }
}

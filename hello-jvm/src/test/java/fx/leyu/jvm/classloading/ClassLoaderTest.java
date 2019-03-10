package fx.leyu.jvm.classloading;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {
    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        System.out.println("super.loadClass class is " + name);
                        return super.loadClass(name);
                    }

                    byte[] bs = new byte[is.available()];
                    is.read(bs);
                    return defineClass(name, bs, 0, bs.length);
                } catch (Exception e) {
                  throw new ClassNotFoundException(e.getMessage());
                }
            }
        };
        Object obj = classLoader.loadClass("fx.leyu.jvm.classloading.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof fx.leyu.jvm.classloading.ClassLoaderTest);
    }
}

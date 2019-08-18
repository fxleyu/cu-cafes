package fx.leyu.jdk.lang.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Optional;

public class JavaProxyTest {
    @Test
    public void test() {
        InvocationHandler handler = new AroundInvocationHandler(new One());
        OneInterface one = (OneInterface) Proxy.newProxyInstance(JavaProxyTest.class.getClassLoader(),
                new Class<?>[] { OneInterface.class }, handler);
        one.hello();

        handler = new AroundInvocationHandler(new Two());
        TwoInterface two = (TwoInterface) Proxy.newProxyInstance(JavaProxyTest.class.getClassLoader(),
                new Class<?>[] { TwoInterface.class }, handler);
        two.hello();
    }

    private static class AroundInvocationHandler implements InvocationHandler {
        private Object proxyImpl;

        AroundInvocationHandler(Object proxyImpl) {
            this.proxyImpl = proxyImpl;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before proxy is " + proxy.getClass().getName());
            Object result = method.invoke(proxyImpl, args);
            System.out.println("after result = " + Optional.ofNullable(result).orElse("null"));
            return result;
        }
    }

    interface OneInterface {
        int hello();
    }

    interface TwoInterface {
        void hello();
    }

    private static class One implements OneInterface {

        @Override
        public int hello() {
            System.out.println("Hello World!");
            return -1;
        }
    }


    private static class Two implements TwoInterface {

        @Override
        public void hello() {
            System.out.println("Hello World! 2");
        }
    }


}

package fx.leyu.jdk.lang;

import org.junit.Assert;
import org.junit.Test;

public class ExceptionTest {

    @Test
    public void testFinallyReturn() {
        Assert.assertEquals(ExceptionDemo.returnStringWithFinally(), ExceptionDemo.FINALLY_STRING);
    }

    @Test(expected = NullPointerException.class)
    public void testFinallyException() {
        ExceptionDemo.getOne();
    }

    @Test(expected = NullPointerException.class)
    public void exceptionPrint() {
        try {
            ExceptionDemo.getOne();
        } catch (Throwable exception) {
            System.out.println(exception.getClass().getSimpleName());
            System.out.println(exception.getClass().getName());
            System.out.println(exception.getClass().getCanonicalName());
            while (!exception.equals(exception.getCause())) {
                exception = exception.getCause();
                System.out.println(exception.getClass().getSimpleName());
                System.out.println(exception.getClass().getName());
                System.out.println(exception.getClass().getCanonicalName());
            }
        }
    }
}

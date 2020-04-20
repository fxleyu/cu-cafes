package fx.leyu.jdk.lang;

import org.junit.Assert;
import org.junit.Test;

public class ExceptionTest {

    @Test
    public void testFinallyReturn() {
        Assert.assertEquals(ExceptionDemo.returnStringWithFinally(), ExceptionDemo.FINALLY_STRING);
    }

    @Test
    public void testFinallyException() {
        System.out.println(ExceptionDemo.getOne());
    }
}

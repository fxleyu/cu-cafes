package fx.leyu.lang.reflect;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClassUtilsTest {

    @Test
    public void testPrintClassMethodMessage() {
        ClassUtils.printClassMethodMessage("String");
    }

    @Test
    public void testPrintClassFieldMessage() {
        ClassUtils.printClassFieldMessage("Test");
    }

    @Test
    public void testPrintClassConstructMessage() {
        ClassUtils.printClassConstructMessage("Test".getClass());
    }

}

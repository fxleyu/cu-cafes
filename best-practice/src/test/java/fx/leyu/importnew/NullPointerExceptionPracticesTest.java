package fx.leyu.importnew;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class NullPointerExceptionPracticesTest {
    @Test(expected = IllegalArgumentException.class)
    public void testAddWithUncertainty() {
        Assert.assertNull(NullPointerExceptionPractices.addWithUncertainty(null, null));
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(NullPointerExceptionPractices.add(1, 1), Integer.valueOf(2));
    }

    /**
     * 用于验证 @Nonnull 只是用来做文档的,默认不会被编译器处理
     */
    @Test(expected = NullPointerException.class)
    public void testAddWithException() {
        Assert.assertEquals(NullPointerExceptionPractices.add(null, 1), Integer.valueOf(2));
    }

    @Test
    public void testGetIntegerWithDefault() {
        Assert.assertEquals(Integer.valueOf(1), NullPointerExceptionPractices.getIntegerWithDefault(null, 1));
    }

    @Test
    public void testIterator() {
        ArrayList<String> list = Lists.newArrayList();
        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

package fx.leyu.jdk.generic;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    @Test
    public void testItem() {
        List rawTypeList = Lists.newArrayList();
        List<Object> genericList = Lists.newArrayList();

        List<String> stringList = Lists.newArrayList();
        rawTypeList = stringList;
        // 编译失败
        //genericList = stringList;
    }

    @Test
    public void testUnsafeAdd() {
        ArrayList<String> stringList = Lists.newArrayList();
        unsafeAdd(stringList, new Integer(2));
        String s = stringList.get(0);
    }

    @Test(expected = ArrayStoreException.class)
    public void testArrayCovariant() {
        Object[] objects = new Long[3];
        objects[0] = "I don't fit in";
    }

    @Test
    public void testListInvariant() {
        // List<Object> objectList = new ArrayList<Long>(); // compile ERROR
        Assert.assertTrue(true);
    }

    private void unsafeAdd(@Nonnull List<?> stringList, @Nonnull Object o) {
        @SuppressWarnings("unchecked")
        List<?> list = (List<?>) o;
        stringList.add(null);
    }
}

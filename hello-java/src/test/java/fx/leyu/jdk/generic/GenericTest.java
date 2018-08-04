package fx.leyu.jdk.generic;

import com.google.common.collect.Lists;
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
        //genericList = stringList;
    }

    @Test
    public void testUnsafeAdd() {
        ArrayList<String> stringList = Lists.newArrayList();
        unsafeAdd(stringList, new Integer(2));
        String s = stringList.get(0);
    }

    private void unsafeAdd(@Nonnull List<?> stringList, @Nonnull Object o) {
        @SuppressWarnings("unchecked")
        List<?> list = (List<?>) o;
        stringList.add(null);
    }
}

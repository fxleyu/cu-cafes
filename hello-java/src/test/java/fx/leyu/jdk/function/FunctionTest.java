package fx.leyu.jdk.function;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionTest {
    @Test
    public void test() {
        Lists.<Supplier<String>>newArrayList(
                () -> {
                    System.out.println(0);
                    return null;
                },
                () -> {
                    System.out.println(1);
                    return null;
                },
                () -> {
                    System.out.println(2);
                    return "";
                },
                () -> {
                    System.out.println(3);
                    return null;
                },
                () -> {
                    System.out.println(4);
                    return null;
                },
                () -> {
                    System.out.println(5);
                    return null;
                },
                () -> {
                    System.out.println(6);
                    return "";
                }
        )
                .stream()
                .map(Supplier::get)
                .filter(Objects::nonNull)
                .findFirst()
                .ifPresent(x -> System.out.println(x));
    }
}

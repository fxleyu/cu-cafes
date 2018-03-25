package fx.leyu.importnew;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

public class NullPointerExceptionPractices {

    public static @Nonnull Integer add(@Nonnull Integer a, @Nonnull Integer b) {
        return 2;
    }

    public static @Nonnull Integer addWithUncertainty(@Nullable Integer a, @Nullable Integer b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            throw new IllegalArgumentException("the args are null");
        }
        return add(a, b);
    }

    public static @Nonnull Integer getIntegerWithDefault(@Nullable Integer value, @Nonnull Integer defaultValue) {
        return Objects.isNull(value) ? defaultValue : value;
    }
}

package fx.leyu.junit4;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

/**
 * @author fxleyu
 */
@RunWith(value = Parameterized.class)
public class ParameterizedTest {

    @Parameterized.Parameters
    public static Collection<Integer> getTestParameters() {
        return null;
    }
}

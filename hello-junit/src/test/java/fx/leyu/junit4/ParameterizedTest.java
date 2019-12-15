package fx.leyu.junit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author fxleyu
 */
@RunWith(value = Parameterized.class)
public class ParameterizedTest {
    private double expected;
    private double valueOne;
    private double valueTwo;

    public ParameterizedTest(double expected, double valueOne, double valueTwo) {
        this.expected = expected;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    @Parameterized.Parameters
    public static Collection<Integer[]> getTestParameters() {
        return Arrays.asList(new Integer[][]{
                {2, 1, 1},
                {3, 2, 1},
                {4, 3, 1},
        });
    }

    @Test
    public void sum() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(expected, calculator.add(valueOne, valueTwo), 0);
    }
}

package fx.leyu.regex;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

public class LookAroundTest {

    @Test
    public void testPositiveLookahead() {
        Assert.assertTrue(canMatch("(?<=Timeout)Exception", "TimeoutException"));
        Assert.assertFalse(canMatch("(?<=Timeout)Exception", "NullPointerException"));
    }

    @Test
    public void testNegativeLookahead() {
        Assert.assertTrue(canMatch("(?<!Timeout)Exception", "NullPointerException"));
        Assert.assertFalse(canMatch("(?<!Timeout)Exception", "TimeoutException"));
    }

    @Test
    public void testPositiveLookbehind () {
        Assert.assertTrue(canMatch("Timeout(?=Exception)", "TimeoutException"));
        Assert.assertFalse(canMatch("Timeout(?=Exception)", "Timeout exception"));
    }

    @Test
    public void testNegativeLookbehind () {
        Assert.assertTrue(canMatch("Timeout(?!Exception)", "Timeout exception"));
        Assert.assertFalse(canMatch("Timeout(?!Exception)", "TimeoutException"));
    }



    private static boolean canMatch(String patternString, String string) {
        return Pattern.compile(patternString).matcher(string).find();
    }
}

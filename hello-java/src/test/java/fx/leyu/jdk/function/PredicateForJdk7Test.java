package fx.leyu.jdk.function;

import org.junit.Assert;
import org.junit.Test;

public class PredicateForJdk7Test {
    @Test
    public void test() {
        PredicateForJdk7 predicate = new PredicateForJdk7() {
            @Override
            public boolean test() {
                return false;
            }
        };

        Assert.assertFalse(predicate.test());
        Assert.assertTrue(predicate.negate().test());
    }
}

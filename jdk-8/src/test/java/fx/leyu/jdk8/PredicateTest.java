package fx.leyu.jdk8;

import java.util.function.Predicate;

public class PredicateTest {
    Predicate<String> isBeginningWithNumber = (value -> Character.isDigit(value.charAt(0)));
    Predicate<String> isNotBeginningWithNumber = isBeginningWithNumber.negate();
}

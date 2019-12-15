package fx.leyu.junit4.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author fxleyu
 */
@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = {TestA.class, TestB.class})
public class TestSuite {
}

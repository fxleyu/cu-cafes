package fx.leyu.learn.junit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({JunitFlowTest.class, JunitAnnotationTest.class, CalculateUtilsTest.class})
public class SuiteTest {
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}

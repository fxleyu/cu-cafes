package fx.leyu.learn.junit4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitFlowTest {

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Before Class ...");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("After Class ...");
    }

    @Before
    public void setUp() {
        System.out.println("Before ....");
    }

    @After
    public void tearDown() {
        System.out.println("After ...");
    }

    @Test
    public void test1() {
        System.out.println("test 1");
    }
    
    @Test
    public void test2() {
        System.out.println("test 2");
    }

}

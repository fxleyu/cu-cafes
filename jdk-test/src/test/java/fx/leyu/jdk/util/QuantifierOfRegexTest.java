package fx.leyu.jdk.util;

import org.junit.*;

public class QuantifierOfRegexTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("setUpBeforeClass");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("tearDownAfterClass");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }
    
    private static final String string = "aaaabcd";
    
    @Test
    public void testTrue() {
        Assert.assertTrue(string.matches("a{1,4}abcd"));
        Assert.assertTrue(string.matches("a{1,4}?abcd"));
    }
    
    @Test
    public void testFalse() {
        Assert.assertFalse(string.matches("a{1,4}+abcd"));
    }

}

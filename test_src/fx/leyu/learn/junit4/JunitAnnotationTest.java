package fx.leyu.learn.junit4;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class JunitAnnotationTest {
    
    /**
     * @Test 将一个普通的方法修饰成一个测试方法
     *     @Test(expected=XxxExeption.class)
     *     @Test(timeout=毫秒)
     * @BeforeClass 在所有方法运行前被执行，static修饰
     * @AfterClass 在所有方法运行后被执行，static修饰
     * @Before 在每个测试方法运行前没执行一次
     * @After 在每个测试方法运行后没执行一次
     * @Ignore 修饰的测试方法不会被执行
     * @RunWith 用于更改测试运行器  默认的为org.junit.runner.Runner
     */

    @Test(expected=ArithmeticException.class)
    public void testDiv() {
        System.out.println("Test");
        Assert.assertEquals("div error", 3, CalculateUtils.div(3, 0));
    }

    @Ignore("Test @Test()")
    @Test(timeout=2000)
    public void testWhile() {
        while(true) {
            System.out.println("Run forever");
        }
    }
    
    @Test(timeout=2001)
    public void testReadFile() throws InterruptedException {
        Thread.sleep(2000);
    }
}

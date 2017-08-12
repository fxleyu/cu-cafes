package fx.leyu.learn.junit4;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTest {
    /**
     * 1、 更改默认的测试运行器为 @RunWith(Parameterized.class)
     * 2、声明变量来存放预期值和结果值
     * 3、声明一个返回值为Collection的公共静态方法，并使用@Parameters进行修饰
     * 4、为测试来声明一个带参数的公共构造函数，并使其中为之声明变量赋值
     */
    
    private int expected;
    private int input1;
    private int input2;
    
    @Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
            {3,2,1},
            {-1,2,-3}
        });
    }
    
    public ParameterTest(int excepted, int input1, int input2) {
        this.expected = excepted;
        this.input1 = input1;
        this.input2 = input2;
    }
    

    @Test
    public void testAdd() {
        Assert.assertEquals(expected, CalculateUtils.add(input1, input2));
    }
}

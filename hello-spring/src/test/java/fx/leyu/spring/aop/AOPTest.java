package fx.leyu.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-aop.xml")
public class AOPTest {
    @Autowired
    private MyBean myBean;
    @Autowired
    private MyOtherBean myOtherBean;

    @Test(expected = IllegalArgumentException.class)
    public void testMyBean() throws InterruptedException {
        myBean.sayHello("world");
    }

    @Test
    public void testMyOtherBean() throws InterruptedException {
        myOtherBean.sayHelloDelayed();
    }
}

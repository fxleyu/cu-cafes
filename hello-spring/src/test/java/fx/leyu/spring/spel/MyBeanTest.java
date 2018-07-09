package fx.leyu.spring.spel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyBeanTest.Config.class)
//@ContextConfiguration("classpath:spring-spel.xml")
public class MyBeanTest {
    @Configuration
    @ComponentScan(basePackages = {"fx.leyu.spring.spel"})
    public static class Config{
    }
    @Autowired
    private MyBean myBean;

    @Test
    public void testMessage() {
        System.out.println(myBean.getMessage());
    }
}

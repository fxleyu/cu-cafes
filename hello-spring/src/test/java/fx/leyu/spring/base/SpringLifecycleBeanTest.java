package fx.leyu.spring.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-base.xml")
//@ContextConfiguration(classes = SpringLifecycleBeanTest.Config.class)
public class SpringLifecycleBeanTest {
    /*@Configuration
    @ComponentScan(basePackages = {"fx.leyu.spring.base"})
    public static class Config{
    }*/

    @Autowired
    private SpringLifecycleBean lifecycleBean;

    @Test
    public void test() {
    }
}

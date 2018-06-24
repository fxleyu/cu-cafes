package fx.leyu.spring.annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanConfigurationTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        School school = context.getBean("school", School.class);
    }
}

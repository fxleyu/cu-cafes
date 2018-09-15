package fx.leyu.spring.domain;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DomainXmlTest {

    @Test
    public void test() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-domain.xml");
        School school = context.getBean("school", School.class);
        Teacher teacher = context.getBean("teacher", Teacher.class);
    }
}

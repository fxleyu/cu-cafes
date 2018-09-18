package fx.leyu.spring.annotation;

import fx.leyu.spring.domain.School;
import fx.leyu.spring.domain.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public School school() {
        School school = new School();
        return school;
    }

    @Bean
    public Teacher teacher() {
        Teacher t = new Teacher();
        return  t;
    }
}

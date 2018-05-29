package fx.leyu.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanConfiguration {
    @Bean
    public School school() {
        School school = new School();

        List<Teacher> teachers = new ArrayList<>(5);
        teachers.add(teacher());
        school.setTeachers(teachers);

        return school;
    }

    @Bean
    public Teacher teacher() {
        Teacher t = new Teacher();
        //t.setSchool(school());
        return  t;
    }
}

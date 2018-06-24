package fx.leyu.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Teacher {
    private School school;

    public School getSchool() {
        return school;
    }

    @Autowired
    public void setSchool(School school) {
        this.school = school;
    }
}

package fx.leyu.spring.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class Teacher {

    private School school;

    public School getSchool() {
        System.out.println("getSchool");
        return school;
    }

    @Autowired
    public void setSchool(School school) {
        System.out.println("setSchool");
        this.school = school;
    }
}

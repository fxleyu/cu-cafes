package fx.leyu.spring.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class School {
    @Autowired
    private Teacher teacher;

    public Teacher getTeacher() {
        System.out.println("getTeacher");
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        System.out.println("setTeacher");
        this.teacher = teacher;
    }
}

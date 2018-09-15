package fx.leyu.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

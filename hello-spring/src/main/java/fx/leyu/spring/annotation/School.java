package fx.leyu.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class School {
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    @Autowired
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}

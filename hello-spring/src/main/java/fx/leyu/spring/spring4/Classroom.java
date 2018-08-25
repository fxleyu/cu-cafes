package fx.leyu.spring.spring4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Classroom {

    @Autowired
    private List<Person> classroomList;

    public List<Person> getClassroomList() {
        return classroomList;
    }
}

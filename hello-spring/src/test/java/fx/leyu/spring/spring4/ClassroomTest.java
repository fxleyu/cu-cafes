package fx.leyu.spring.spring4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-classroom.xml")
public class ClassroomTest {
    @Autowired
    private Classroom classroom;

    @Test
    public void testList() {
        System.out.println(classroom.getClassroomList());
    }
}

package fx.leyu.designpattern.chainofresponsibility;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-chain-of-responsibility-test.xml")
public class MarkingCustomTest {
    @Autowired
    MarkingHandler markingHandler;

    @Test
    public void test() {
        markingHandler.handleMarking();
    }
}

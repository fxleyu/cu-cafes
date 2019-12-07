package fx.leyu.spring.boot;

import fx.leyu.spring.boot.api.Love;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author fxleyu
 */
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private Love love;
    @Test
    void contextLoads() {
        love.greet();
    }
}

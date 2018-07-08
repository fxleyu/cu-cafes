package fx.leyu.spring.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring-cache.xml")
@ContextConfiguration(classes = ApplicationConfig.class)
public class UserInfoServiceTest {
    @Autowired
    private UserInfoService service;

    @Test
    public void testCache() {
        service.getUserInfo("fxleyu");
        service.getUserInfo("fxleyu");
    }
}

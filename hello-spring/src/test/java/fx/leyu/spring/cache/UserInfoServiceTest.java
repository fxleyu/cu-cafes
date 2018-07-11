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
    public void testgetUserInfoString() {
        service.getUserInfo("fxleyu");
        service.getUserInfo("fxleyu");
        System.out.println("----");
        service.getUserInfo("fxyuer");
        service.getUserInfo("fxyuer");
    }

    @Test
    public void testgetUserInfoUser() {
        User fxleyu = new User("fxleyu", "cn");
        User fxyuer = new User("fxyuer", "cn");
        service.getUserInfo(fxleyu);
        service.getUserInfo(fxyuer);
        System.out.println("----");
        service.getUserInfo(fxyuer);
        service.getUserInfo(fxleyu);
    }
}

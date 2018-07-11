package fx.leyu.spring.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserInfoService {
    private static Map<String, String> userInfoMap = new HashMap<>();

    static {
        userInfoMap.put("fxleyu", "fxleyu@qq.com");
        userInfoMap.put("fxyuer", "fxyuer@163.com");
    }

    @Cacheable(value = "userInfoCache")
    public String getUserInfo(String user) {
        System.out.println("User requested " + user);
        return userInfoMap.get(user);
    }

    @Cacheable(value = "userInfoCache", key = "#user.name")
    //@Cacheable(value = "userInfoCache")
    public String getUserInfo(User user) {
        System.out.println("User requested " + user);
        return userInfoMap.get(user.getName());
    }
}

package fx.leyu.spring.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class UserInfoService {
    private static final Map<String, String> userInfoMap = new HashMap<>();

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

    @Cacheable(value = "userInfoCache", condition = "#user.name == 'fxleyu'")
    public String getUserInfoWithCondition(User user) {
        System.out.println("User requested " + user);
        return userInfoMap.get(user.getName());
    }

    @Caching(cacheable = {
            @Cacheable(value="stringCache", condition = "#obj instanceof T(String)"),
            @Cacheable(value = "userCache", condition = "#obj instanceof T(fx.leyu.spring.cache.User)")
    })
    public String getUserInfoByObject(Object obj) {
        if (obj instanceof String) {
            return getUserInfo(Objects.toString(obj));
        } else if (obj instanceof User) {
            return getUserInfo((User) obj);
        }
        return null;
    }
}

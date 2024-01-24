package fx.leyu.jdk.lang.json;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class JsonMain {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        String str = JSON.toJSONString(map);
        System.out.println(str);
    }
}

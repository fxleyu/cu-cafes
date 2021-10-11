package fx.leyu.jdk.util;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Map;

public class StringUtils {
    @Test
    public void test() {
        Map<String, Object> map = JSON.parseObject("{\"redeemCodeList\": [\"22\",\"22\"]}");
        System.out.println(map);
    }
}

package fx.leyu.jdk.lang;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.MapUtils;
import org.junit.Test;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListTest {
    private static final Map<String, Integer> CODE_SORT = Maps.newHashMap();
    static {
        CODE_SORT.put("IN", 1);
        CODE_SORT.put("CN_INNER", 2);
        CODE_SORT.put("MX", 3);
        CODE_SORT.put("UK", 4);
        CODE_SORT.put("US", 5);
        CODE_SORT.put("BR", 6);
    }


    @Test
    public void testListSort() {
        List<SortObject> list = Lists.newArrayList(new SortObject("IN", "印度"),
                new SortObject("CN_INNER", "中国内购"),
                new SortObject("MX", "墨西哥"),
                new SortObject("UK", "英国"),
                new SortObject("US", "美国"),
                new SortObject("BR", "巴西"),
                new SortObject("BR", "巴西2"),
                new SortObject("IN", "印度x"),
                new SortObject("CN_INNER", "中国内购x"),
                new SortObject("MX", "墨西哥x"),
                new SortObject("UK", "英国x"),
                new SortObject("US", "美国x"),
                new SortObject("BR", "巴西x"));
        list = list.stream()
                .sorted(Comparator.comparingInt(a -> MapUtils.getIntValue(CODE_SORT, a.code, -1)))
                .collect(Collectors.toList());
        System.out.printf(JSON.toJSONString(list));
    }

    public static class SortObject implements Serializable {
        String code;
        String value;

        public SortObject(String code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

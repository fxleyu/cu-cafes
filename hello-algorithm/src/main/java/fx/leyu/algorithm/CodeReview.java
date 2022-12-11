package fx.leyu.algorithm;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhuzhihui
 */
public class CodeReview {

    public static void main(String[] args) {
        List<String> names = Lists.newArrayList("沈津生(列星) Jason", "孟成 Mc", "钟琼华(天然子)", "马文相(墨大) Moda", "朱智慧 Vincent", "朱智慧 Vincent", "贾程浩 Chenghao", "林礼狮(锄头) Larson");
        Collections.shuffle(names);
        System.out.println(Arrays.toString(names.toArray()));
        System.out.println("1208 10:00 - 12:00: " + names.get(0) + "," + names.get(1));
        System.out.println("1215 10:00 - 12:00: " + names.get(2) + "," + names.get(3));
        System.out.println("1222 10:00 - 12:00: " + names.get(4) + "," + names.get(5));
        System.out.println("1229 10:00 - 12:00: " + names.get(6) + "," + names.get(7));
    }
}

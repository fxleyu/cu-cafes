package fx.leyu.jdk.lang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuzhihui
 */
public class MethodMain {

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(JSON.toJSONString(null));
        Long nll = null;
        Long x = RandomUtils.nextInt(6, 9) > 6 ? nll : 0L;


        Model model = new Model();
        Field[] fields = Model.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName());
            System.out.println(field.get(model));
        }

        List<Integer> array = Lists.newArrayList(1,2,3,4,5);
        System.out.println("X " + JSONObject.toJSONString(array));
        array = new ArrayList<>(array);
        array.addAll(Lists.newArrayList(7,8,9));
        System.out.println("X " + JSONObject.toJSONString(array));
        loop();
    }

    public static void loop() {
        loop();
    }
    public static class Model {
        private String a = "aValue";
        private String b = "bValue";
        private String c = "cValue";

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }
    }
}

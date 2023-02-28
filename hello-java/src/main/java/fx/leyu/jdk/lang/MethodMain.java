package fx.leyu.jdk.lang;

import java.lang.reflect.Field;

public class MethodMain {

    public static void main(String[] args) throws IllegalAccessException {
        Model model = new Model();
        Field[] fields = Model.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName());
            System.out.println(field.get(model));
        }
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

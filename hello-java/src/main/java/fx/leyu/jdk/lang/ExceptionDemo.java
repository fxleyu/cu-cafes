package fx.leyu.jdk.lang;

public class ExceptionDemo {
    public static final String NORMAL_STRING = "normal string";
    public static final String FINALLY_STRING = "finally string";

    public static String returnStringWithFinally() {
        try {
            return NORMAL_STRING;
        } finally {
            return FINALLY_STRING;
        }
    }

    public static int getOne() {
        try {
            return 1;
        } finally {
            throw new NullPointerException("x");
        }
    }
}

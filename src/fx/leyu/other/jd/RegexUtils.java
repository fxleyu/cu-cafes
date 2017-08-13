package fx.leyu.other.jd;

public class RegexUtils {
    
    public static boolean isABPattern(String string) {
        System.out.println("-ddddd".indexOf('-', 1));
        return string.matches(".+-.+");
    }
    
    public static boolean isABPatternOther(String string) {
        if (string.length() < 3) {
            return false;
        }
        return string.indexOf('-', 1) < string.length() - 1;
    }
}

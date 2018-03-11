package fx.leyu.jdk.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {
    final public static String datePatternStr = "([12][0-9]{3,3})[-\\./]?([01]?[0-9])[-\\./]?([0-3]?[0-9])";
    private static String input = "都市报道60分 (2016-08-08） && 2016年3月2日黄历|农历2016-3-2吉时 -汉典老黄历 && ​一周吉凶提醒 2015/12/15-2015/12/21_姜宜绘_新浪博客";

    public static void main(String[] args) {
        Pattern datePattern = Pattern.compile(datePatternStr);
        Matcher matcher = datePattern.matcher(input);
        System.out.println(matcher.replaceAll("$1年$2月$3日"));
        System.out.println(Pattern.quote("xf&*."));
    }
}

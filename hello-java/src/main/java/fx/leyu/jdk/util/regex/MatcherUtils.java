package fx.leyu.jdk.util.regex;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherUtils {

    public interface MatchFilter {
        boolean acceptMatch(Matcher matcher, String input);
    }

    public interface TransformFilter {
        String transformUrl(Matcher match, String url);
    }

    public static String replaceAll(String input, Pattern pattern, String replacement, MatchFilter matchFilter) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            StringBuffer sb = new StringBuffer();
            do {
                if (matchFilter.acceptMatch(matcher, input)) {
                    matcher.appendReplacement(sb, replacement);
                }
            } while (matcher.find());
            matcher.appendTail(sb);
            return sb.toString();
        }   
        return input;
    }
    
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("([0-9]+)[-\\./]+([01]?[0-9])[-\\./]+([0-3]?[0-9])");
        String input = "都市报道60分 (2016-08-28） && 2016年3月2日黄历|农历2016-12-30吉时 -汉典老黄历 && ​一周吉凶提醒 2015/12/15-2015/12/21_姜宜绘_新浪博客";
        String replacement = "$1年$2月$3日";
        MatchFilter matchFilter = new MatchFilter() {
            Set<Integer> set = new HashSet<Integer>();
            {
                set.add(4);
                set.add(6);
                set.add(9);
                set.add(11);
            }
            
            @Override
            public boolean acceptMatch(Matcher matcher, String input) {
                int year = Integer.valueOf(input.substring(matcher.start(1), matcher.end(1)));
                int month = Integer.valueOf(input.substring(matcher.start(2), matcher.end(2)));
                int day = Integer.valueOf(input.substring(matcher.start(3), matcher.end(3)));
                if (year < 1 || month < 1 || month > 12 || day < 1 || day > 31) {
                    return false;
                }
                
                if (set.contains(month)) {
                    return day < 31;
                } else if (month == 2) {
                    return day < 29;
                }
                
                return true;
            }
        };
        
        System.out.println(replaceAll(input, pattern, replacement, matchFilter));
    }
}

package fx.leyu.jdk.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 接口 MatchResult
 * Matcher
 * Pattern
 *
 * @author fxleyu
 */
public class RegexDemo {
    private static final Pattern PATTERN = Pattern.compile("(ab)(cd(?:ef))");
    public static void main(String[] args) {

        // System.out.println(pattern.quote("fxleyu")); 测试
        Matcher matcher = PATTERN.matcher("abcdefddabcdef");
        System.out.println(matcher.replaceAll("$1--3$2--3$2---0$0"));
        System.out.println(matcher);
        matcher.reset();
        System.out.println(matcher);
        while (matcher.find()) {
            System.out.println("matcher.find()");
            System.out.println(matcher.group());
            
        }
        matcher.reset();
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println("intersection");
        }
        System.out.println(matcher);
        matcher.reset();
        System.out.println(matcher);
        // matcher.matchers() 尝试匹配
        if (matcher.matches()) {
            System.out.println(matcher.matches());
            System.out.println(matcher.group());
            System.out.println("matcher.end()" + matcher.end());
        } 
        System.out.println("Game\t Over!");
        String n = "\\E";
        System.out.println(n.length());
        System.out.println(n);
    }

}

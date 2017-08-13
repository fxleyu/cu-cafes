package fx.leyu.jdk.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 接口 MatchResult
 * Matcher
 * Pattern
 */
public class RegexDemo {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(ab)(cd(?:ef))");
        //System.out.println(pattern.quote("fxleyu"));
        Matcher matcher = pattern.matcher("abcdefddabcdef");
        System.out.println(matcher.replaceAll("$1--3$2--3$2---0$0"));
        System.out.println(matcher);
        matcher = matcher.reset();
        System.out.println(matcher);
        while (matcher.find()) {
            System.out.println("matcher.find()");
            System.out.println(matcher.group());
            
        }
        matcher = matcher.reset();
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println("intersection");
        }
        System.out.println(matcher);
        matcher = matcher.reset();
        System.out.println(matcher);
        if (matcher.matches()) { // matcher.matchers() 尝试匹配
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

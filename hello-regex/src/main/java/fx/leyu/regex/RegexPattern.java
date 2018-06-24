package fx.leyu.regex;

public class RegexPattern {
    public static final String ESCAPE_CHARACTER = "\\";             // 转义字符
    public static final String MONTH_PATTERN = "(1[0-2])|[1-9]";   // 月份
    public static final String DOT_CHARACTER = ".";                 // 任意字符
    public static final String NET_NAME_PATTERN = "[Ff]x[Ll]eyu";  // 区间匹配
    public static final String NOT_NUMBER_PATTERN = "[^0-9]";       // 非数字
}

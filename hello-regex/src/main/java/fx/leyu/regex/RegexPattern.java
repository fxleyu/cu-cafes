package fx.leyu.regex;

public class RegexPattern {
    public static final String ESCAPE_CHARACTER = "\\";             // 转义字符
    public static final String MONTH_PATTERN = "(1[0-2])|[1-9]";   // 月份
    public static final String DOT_CHARACTER = ".";                 // 任意字符
    public static final String NET_NAME_PATTERN = "[Ff]x[Ll]eyu";  // 区间匹配
    public static final String NOT_NUMBER_PATTERN = "[^0-9]";       // 非数字
    public static final String ARRAY_ZERO_MARK = "\\[0\\]";
    public static final String NUMBER_METACHARACTER = "\\d";
    public static final String NOT_NUMBER_METACHARACTER = "\\D";
    public static final String WHITE_METACHARACTER = "\\s";
    public static final String NOT_WHITE_METACHARACTER = "\\S";
    public static final String AL_NUM_POSIX = "\\p{Alnum}";           //  java 不支持 POSIX 字符
    public static final String EMAIL_PATTERN = "\\w+@\\w+\\.\\w+";
}

package fx.leyu.regex;

public class RegexPattern {
    public static final String ESCAPE_CHARACTER = "\\";             // 转义字符
    public static final String MONTH_PATTERN = "(1[0-2])|[1-9]";   // 月份
    public static final String DOT_CHARACTER = ".";                 // 任意字符
    public static final String NET_NAME_PATTERN = "\\b[Ff]x[Ll]eyu\\b";  // 区间匹配
    public static final String NOT_NUMBER_PATTERN = "[^0-9]";       // 非数字
    public static final String ARRAY_ZERO_MARK = "\\[0\\]";
    public static final String NUMBER_METACHARACTER = "\\d";
    public static final String NOT_NUMBER_METACHARACTER = "\\D";
    public static final String WHITE_METACHARACTER = "\\s";
    public static final String NOT_WHITE_METACHARACTER = "\\S";
    public static final String AL_NUM_POSIX = "\\p{Alnum}";           //  java 不支持 POSIX 字符
    public static final String EMAIL_PATTERN = "\\w+@\\w+\\.\\w+";
    public static final String MY_HOME_PAGE = "https?://fxleyu.github.io/";
    public static final String THREE_ONES = "1{3}";
    public static final String THREE_TO_FIVE_ONES = "1{3,5}";
    public static final String AT_LEAST_THREE_ONES = "1{3,}";
    public static final String BOLD_TYPE_ERROR = "<[bB]>.*</[bB]>";  // 贪婪模式
    public static final String BOLD_TYPE = "<[bB]>.*?</[bB]>";        // 懒惰模式
    public static final String PATTERN_0_255 = "((1?\\d{1,2})|2(([0-4]\\d)|(5[0-5])))";
    public static final String IP_PATTERN = "(" + PATTERN_0_255 + "\\.){3}" + PATTERN_0_255;
    public static final String HEAD_PATTERN = "<[hH]([1-6])>.*?</[hH]\\1>";
    public static final String TWO_SAME_WORDS = "(\\w+)\\W+\\1";
    public static final String PROTOCOL_PATTERN = "\\b\\w+?(?=://)";   // 向前查找
    public static final String COMMA_DELIMITED_NUMBERS = "(\\d+,)+(\\d+)";
}

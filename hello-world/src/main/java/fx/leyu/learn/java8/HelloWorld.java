package fx.leyu.learn.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HelloWorld {
    private static Comparator<String> customizeComparator = (str1, str2) -> {
        if (str1.endsWith("fr") ^ str2.endsWith("fr")) {
            return str1.endsWith("fr") ? -1 : 1;
        }
        if (str1.endsWith("com") ^ str2.endsWith("com")) {
            return str1.endsWith("com") ? -1 : 1;
        }
        return str1.compareTo(str2);
    };
    
    public static void main(String[] args) {
        List<String> list = getAllProviderDomain();
        for (String str : list) {
            System.out.println(str);
        }
    }

    public static List<String> getAllProviderDomain() {
        List<Provider> providerList = getAllProvider();
        return providerList.stream()
                .filter((provider) -> !provider.domain.contains("("))
                .map((provider) -> provider.domain)
                .sorted(customizeComparator)
                .collect(Collectors.toList());
    }

    private static List<Provider> getAllProvider() {
        List<Provider> result = new ArrayList<>();
        result.add(new Provider("outlook.com(POP3)"));
        result.add(new Provider("hotmail.hk"));
        result.add(new Provider("hotmail.com.fr"));
        result.add(new Provider("gmail.fr"));
        result.add(new Provider("gmail.fr(POP3)"));
        result.add(new Provider("android.com"));
        result.add(new Provider("163.com"));
        result.add(new Provider("yahoo.jp"));
        result.add(new Provider("yahoo.com"));
        result.add(new Provider("yahoo.com.fr"));
        result.add(new Provider("outlook.com(IMAP)"));
        result.add(new Provider("outlook.com"));
        result.add(new Provider("y7mail.fr"));
        result.add(new Provider("qq.com"));
        return result;
    }

}

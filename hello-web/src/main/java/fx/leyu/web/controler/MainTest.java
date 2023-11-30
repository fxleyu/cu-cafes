package fx.leyu.web.controler;

import org.apache.commons.validator.routines.UrlValidator;

import java.util.Optional;

public class MainTest {
    public static void main(String[] args) {
        String url = Optional.ofNullable("https://img101.urbanic.com/97d88848e3ff449c80fae0e81b58bb5f")
                .filter(x -> UrlValidator.getInstance().isValid(x))
                .orElse(null);
        System.out.println(url);
    }
}

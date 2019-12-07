package fx.leyu.spring.boot.service;

import fx.leyu.spring.boot.api.Love;
import org.springframework.stereotype.Service;

/**
 * @author fxleyu
 */
@Service
public class FxLove implements Love {
    @Override
    public void greet() {
        System.out.print("hello world!");
    }
}

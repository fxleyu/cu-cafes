package fx.leyu.spring.boot.service;

import fx.leyu.spring.boot.api.Love;
import fx.leyu.spring.boot.domain.Person;
import org.springframework.stereotype.Service;

/**
 * @author fxleyu
 */
@Service
public class FxLove implements Love {
    @Override
    public void greet() {
        Person person = new Person();
        person.setName("fxleyu");
        System.out.print(person.getName());
        System.out.print(", hello world!");
    }
}

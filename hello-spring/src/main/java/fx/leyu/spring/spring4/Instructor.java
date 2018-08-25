package fx.leyu.spring.spring4;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Instructor extends Person {
}

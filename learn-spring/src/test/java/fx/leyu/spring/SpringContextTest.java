package fx.leyu.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringContextTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
        context.close();
    }

}

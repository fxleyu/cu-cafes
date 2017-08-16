package fx.leyu.learn.springframework;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fx.leyu.learn.springframework.Application;
import fx.leyu.learn.springframework.MessagePrinter;

public class SpringContextTest {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }

}

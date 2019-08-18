package fx.leyu.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyOtherBean {
    @Autowired
    MyBean myBean;
    public void sayHelloDelayed() throws InterruptedException {
        Thread.sleep(1000);
        new RuntimeException("print").printStackTrace();
        System.out.println("Hello ......");
    }
}

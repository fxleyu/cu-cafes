package fx.leyu.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class MyBean {
    public void sayHello(String world) {
        System.out.println("Hello " + world);
        throw new IllegalArgumentException("不合法参数");
    }
}

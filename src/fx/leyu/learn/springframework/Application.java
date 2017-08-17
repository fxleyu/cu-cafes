package fx.leyu.learn.springframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {
    
    @Bean(initMethod="fxInit", destroyMethod="fxDestory")
    MessageService mockMessageService() {
        return new MessageService() {
            @Override
            public String getMessage() {
                return "Hello World!";
            }
            
            public void fxInit() {
                System.out.println("fxInit");
            }
            
            public void fxDestory() {
                System.out.println("fxDestory");
            }
            
        };
    }
}

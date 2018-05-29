package fx.leyu.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
    
    final private MessageService service;
    
    @Autowired
    public MessagePrinter(MessageService mockMessageService) {
        this.service = mockMessageService;
    }
    
    public void printMessage() {
        System.out.println(service.getMessage());
    }
    
    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct");
    }
    
    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy");
    }
}

package fx.leyu.designpattern.chainofresponsibility;

import fx.leyu.designpattern.chainofresponsibility.handler.ChoicenessMarkingHandler;
import fx.leyu.designpattern.chainofresponsibility.handler.SupermarketMarkingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MarkingHandlerFactory {
    @Bean("markingHandler")
    public static MarkingHandler gainMarkingHandler() {
        MarkingHandler markingHandler = new ChoicenessMarkingHandler();
        MarkingHandler supermarketMarkingHandler = new SupermarketMarkingHandler();

        markingHandler.setSuccessor(supermarketMarkingHandler);

        return markingHandler;
    }
}

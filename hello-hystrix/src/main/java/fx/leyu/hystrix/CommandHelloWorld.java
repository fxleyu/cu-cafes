package fx.leyu.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.apache.commons.lang3.RandomUtils;

public class CommandHelloWorld extends HystrixCommand<String> {

    private final String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() {
        //System.out.println("Hello " + name + "!");
        if (RandomUtils.nextInt(1, 20) < 10) {
            throw new RuntimeException("ERROR");
        }
        return "Hello " + name + "!";
    }

    @Override
    protected String getFallback() {
        return "ERROR";
    }
}
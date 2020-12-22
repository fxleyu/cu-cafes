package fx.leyu.rpc.api.impl;

import fx.leyu.rpc.api.HelloWorldService;

public class DefaultHelloWorldService implements HelloWorldService {
    @Override
    public String sayHello(String name) {
        return name + ", hello world";
    }
}

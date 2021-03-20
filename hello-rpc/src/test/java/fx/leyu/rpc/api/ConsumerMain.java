package fx.leyu.rpc.api;

import fx.leyu.rpc.RpcFramework;

public class ConsumerMain {
    public static void main(String[] args) throws Exception {
        HelloWorldService service = RpcFramework.refer(HelloWorldService.class, "127.0.0.1", 8892);
        System.out.println(service.sayHello("fxleyu"));
    }
}

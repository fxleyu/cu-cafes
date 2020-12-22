package fx.leyu.rpc.api;

import fx.leyu.rpc.RpcFramework;
import fx.leyu.rpc.api.impl.DefaultHelloWorldService;

public class ProviderMain {
    public static void main(String[] args) throws Exception {
        HelloWorldService service = new DefaultHelloWorldService();
        RpcFramework.export(service, 8892);
    }
}

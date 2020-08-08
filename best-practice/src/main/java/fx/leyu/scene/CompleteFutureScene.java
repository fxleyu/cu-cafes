package fx.leyu.scene;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 场景模拟
 *
 * @author fxleyu
 */
public class CompleteFutureScene {
    @Test
    public void test() {
        CompletableFuture<List<String>> userCenterFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("userCenterFuture thread = " + Thread.currentThread().getName());
            return Lists.newArrayList(Thread.currentThread().getName());
        });
        CompletableFuture<List<String>> strategyFlowFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("strategyFlowFuture thread = " + Thread.currentThread().getName());
            return Lists.newArrayList(Thread.currentThread().getName());
        });
        List<String> result = userCenterFuture.thenCombineAsync(strategyFlowFuture, (userCenter, strategyFlow) -> {
            System.out.println("thenCombine thread = " + Thread.currentThread().getName());
            userCenter.addAll(strategyFlow);
            return userCenter;
        }).join();
        System.out.println(result);
    }
}

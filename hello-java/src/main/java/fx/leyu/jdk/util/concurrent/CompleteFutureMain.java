package fx.leyu.jdk.util.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author fxleyu
 */
public class CompleteFutureMain {
    public static void main(String[] args) {
        CompletableFuture<String> one = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "one#";
        });
        CompletableFuture<String> two = one.handleAsync((s, e) -> {
            try {
                TimeUnit.HOURS.sleep(90);
            } catch (InterruptedException x) {
                x.printStackTrace();
            }
           return s + "two#";
        });

        CompletableFuture<String> three = one.handle((s, e) -> {
            try {
                TimeUnit.HOURS.sleep(90);
            } catch (InterruptedException x) {
                x.printStackTrace();
            }
            return s + "three#";
        });

        CompletableFuture<String> four = two.thenCombineAsync(three, (s3, s4) -> {
            try {
                TimeUnit.HOURS.sleep(90);
            } catch (InterruptedException x) {
                x.printStackTrace();
            }
            return s3 + s4 + "four";
        });


        CompletableFuture<String> result = four.exceptionally(e -> "");
        result.join();
    }
}

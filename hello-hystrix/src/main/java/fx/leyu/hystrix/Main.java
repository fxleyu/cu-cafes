package fx.leyu.hystrix;

import rx.Observable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String s = new CommandHelloWorld("Bob").execute();
        Future<String> future = new CommandHelloWorld("Bob").queue();
        System.out.println("MAIN " + future.get());
        Observable<String> observable = new CommandHelloWorld("Bob").observe();
        //observable.
    }
}

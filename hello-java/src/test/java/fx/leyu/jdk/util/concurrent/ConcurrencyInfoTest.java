package fx.leyu.jdk.util.concurrent;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.function.Consumer;

public class ConcurrencyInfoTest {
    private static final CyclicBarrier START_BARRIER = new CyclicBarrier(10);
    private static final CyclicBarrier END_BARRIER  = new CyclicBarrier(10);
    private static final ConcurrencyInfo INFO = new ConcurrencyInfo();
    private static final ExecutorService SERVICE = Executors.newFixedThreadPool(9);

    @Test
    public void test() throws InterruptedException, BrokenBarrierException {

        for (int i = 0; i < 10000; i++) {
            function((f)-> f.setOneStrings(new ArrayList<String>()));
            function((f)-> f.setTwoStrings(new ArrayList<String>()));
            function((f)-> f.setThreeStrings(new ArrayList<String>()));
            function((f)-> f.setFourStrings(new ArrayList<String>()));
            function((f)-> f.setFiveStrings(new ArrayList<String>()));
            function((f)-> f.setSixStrings(new ArrayList<String>()));
            function((f)-> f.setSevenStrings(new ArrayList<String>()));
            function((f)-> f.setEightStrings(new ArrayList<String>()));
            function((f)-> f.setNineStrings(new ArrayList<String>()));
            START_BARRIER.await();
            END_BARRIER.await();
            Assert.assertNotNull(INFO.getOneStrings());
            Assert.assertNotNull(INFO.getTwoStrings());
            Assert.assertNotNull(INFO.getThreeStrings());
            Assert.assertNotNull(INFO.getFourStrings());
            Assert.assertNotNull(INFO.getFiveStrings());
            Assert.assertNotNull(INFO.getSixStrings());
            Assert.assertNotNull(INFO.getSevenStrings());
            Assert.assertNotNull(INFO.getEightStrings());
            Assert.assertNotNull(INFO.getNineStrings());
            START_BARRIER.reset();

            END_BARRIER.reset();
            function((f)-> f.setOneStrings(null));
            function((f)-> f.setTwoStrings(null));
            function((f)-> f.setThreeStrings(null));
            function((f)-> f.setFourStrings(null));
            function((f)-> f.setFiveStrings(null));
            function((f)-> f.setSixStrings(null));
            function((f)-> f.setSevenStrings(null));
            function((f)-> f.setEightStrings(null));
            function((f)-> f.setNineStrings(null));
            START_BARRIER.await();
            START_BARRIER.reset();
            END_BARRIER.await();
            END_BARRIER.reset();
        }
    }

    private void function(Consumer<ConcurrencyInfo> consumer) {
        SERVICE.execute(() -> {
            try {
                START_BARRIER.await();
                consumer.accept(INFO);
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    END_BARRIER.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

package fx.leyu.jdk.lang;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ThreadProblem {
    private static final BigDecimal FOUR = BigDecimal.valueOf(4);
    private static final int roundingMode = BigDecimal.ROUND_HALF_EVEN;

    private static BigDecimal result;

    /**
     *  很遗憾，没有复现书中的缓存变量的问题 jdk-9.0.1
     */
    @Test
    public void testCachedVariables() {
        Runnable runnable = () -> result = computePi(50000);

        Thread thread = new Thread(runnable);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print(result);
    }

    public static BigDecimal computePi(int digits) {
        int scale = digits + 5;
        BigDecimal arctan1_5 = arctan(5, scale);
        BigDecimal arctan1_239 = arctan(239, scale);
        BigDecimal pi = arctan1_5.multiply(FOUR).
                subtract(arctan1_239).multiply(FOUR);
        return pi.setScale(digits, RoundingMode.HALF_UP);
    }

    public static BigDecimal arctan(int inverseX, int scale) {
        BigDecimal result, numer, term;
        BigDecimal invX = BigDecimal.valueOf(inverseX);
        BigDecimal invX2 = BigDecimal.valueOf((long) inverseX * inverseX);
        numer = BigDecimal.ONE.divide(invX, scale, RoundingMode.HALF_EVEN);
        result = numer;
        int i = 1;
        do {
            numer = numer.divide(invX2, scale, RoundingMode.HALF_EVEN);
            int denom = 2 * i + 1;
            term = numer.divide(BigDecimal.valueOf(denom), scale,
                    RoundingMode.HALF_EVEN);
            if ((i % 2) != 0)
                result = result.subtract(term);
            else
                result = result.add(term);
            i++;
        }
        while (term.compareTo(BigDecimal.ZERO) != 0);
        return result;
    }
}

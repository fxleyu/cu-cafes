package fx.leyu.jdk.lang;

import org.junit.Test;

public class JustTest {
    @Test
    public void test() {
        double x = 1 - f(0) - f(1) - f(2) - f(3) - f(4) - f(5);
        System.out.println("result : " + x);
    }

    private double f(int i) {
        return c(40, i) * q(0.6, i) * q(0.4, 40 - i);
    }

    private double q(double v, int n) {
        if (n == 0) {
            System.out.println(v + "^" + n + " = " + 1);
            return 1;
        }
        double x = 1;
        for (int i = 1; i <= n; i++) {
            x = x * v;
        }
        System.out.println(v + "^" + n + " = " + x);
        return x;
    }

    private int c(int n, int m) {
        if (m == 0) {
            System.out.println("C(" + m + ", " + n + ") = " + 1);
            return 1;
        }
        int x = 1;
        int y = 1;
        for (int i = 1; i <= m; i++) {
            x = x * i;
            y = y * (n - i + 1);
        }
        int result =  y / x;
        System.out.println("C(" + m + ", " + n + ") = " + result);
        return result;
    }
}

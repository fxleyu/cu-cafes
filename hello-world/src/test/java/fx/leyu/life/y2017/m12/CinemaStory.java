package fx.leyu.life.y2017.m12;

import org.junit.Test;

public class CinemaStory {
    
    // JUST for https://github.com/fxleyu/fxleyu.github.io/issues/62
    @Test
    public void calculate() {
        long a = 1;
        long b = 1;
        for (int i = 1; i <= 13; i++) {
            a *= i;
            b *= (i + 14);
        }
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("Probability = " + (a * 1.0 ) / b);
        
    }
}

package fx.leyu.jdk.lang;

import org.apache.commons.lang3.RandomUtils;

/**
 * break 标签
 *
 * @author fxleyu
 */
public class GrammarMain {
    public static void main(String[] args) {
        int x = RandomUtils.nextInt();
        fx:
        if (x < 0) {
            if (x < -5) {
                System.out.println(x);
                break fx;
            }
        }

        System.out.println("end");
    }
}

package fx.leyu.interview.ant;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class MessageUtilsTest {
    @Test
    public void test() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("input"));
        Message[] result = MessageUtils.nearestKMessages(scanner, 2);
        scanner.close();
        System.out.println(Arrays.toString(result));
    }
}

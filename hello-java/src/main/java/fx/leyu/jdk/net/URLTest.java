package fx.leyu.jdk.net;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class URLTest {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()) {
            System.out.println(new String(scanner.nextLine().getBytes(), StandardCharsets.UTF_8));
        }
        scanner.close();
    }

}

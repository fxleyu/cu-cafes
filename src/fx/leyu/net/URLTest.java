package fx.leyu.net;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class URLTest {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()) {
            System.out.println(new String(scanner.nextLine().getBytes(), "utf-8"));
        }
        scanner.close();
    }

}

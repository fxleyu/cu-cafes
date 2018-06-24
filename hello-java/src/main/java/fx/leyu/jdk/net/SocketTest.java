package fx.leyu.jdk.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10240);
        Scanner scanner = new Scanner(socket.getInputStream());
        System.out.println(new String(scanner.nextLine().getBytes(), "utf-8"));
        scanner.close();
        socket.close();
    }

}

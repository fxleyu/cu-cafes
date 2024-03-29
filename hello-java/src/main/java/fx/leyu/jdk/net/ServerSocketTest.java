package fx.leyu.jdk.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerSocketTest {

    public static void main(String[] args) throws IOException {
        @SuppressWarnings("resource")
        ServerSocket ss = new ServerSocket(10240);
        while (true) {
            Socket socket = ss.accept();
            new Thread(() -> {
                try {
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("Hi, 我是乐雨！".getBytes(StandardCharsets.UTF_8));
                    outputStream.close();
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }).start();
        }
    }

}

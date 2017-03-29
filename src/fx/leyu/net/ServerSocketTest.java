package fx.leyu.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {

    public static void main(String[] args) throws IOException {
        @SuppressWarnings("resource")
        ServerSocket ss = new ServerSocket(10240);
        while (true) {
            Socket socket = ss.accept();
            new Thread(new Runnable() {
                public void run() {
                    try {
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write("Hi, 我是乐雨！".getBytes("utf-8"));
                        outputStream.close();
                        socket.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}

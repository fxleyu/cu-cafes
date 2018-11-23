package fx.leyu.jdk.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SplitFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("D://TEST.log");

        FileChannel fcin = fin.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024000); // 约 1MB

        for (int i = 0; ; i++) {
            FileOutputStream fout = new FileOutputStream("D://TEST" + i + ".log");
            System.out.println("处理 TEST" + i + ".log ...");
            FileChannel fcout = fout.getChannel();

            for (int j = 0; j < 100; j++) {
                buffer.clear();
                int r = fcin.read(buffer);

                // 状态检查
                if (r == -1) {
                    fin.close();
                    fcout.close();
                    return;
                }

                buffer.flip();

                fcout.write(buffer);
            }
            fcout.close();
        }
    }

}

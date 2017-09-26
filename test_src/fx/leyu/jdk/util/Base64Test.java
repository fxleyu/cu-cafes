package fx.leyu.jdk.util;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.junit.Test;

public class Base64Test {

    @Test
    public void test() {
        Encoder encoder = Base64.getEncoder();
        String encoderString = encoder.encodeToString("Hello world! ".getBytes());
        System.out.println(encoderString);
        
        Decoder decoder = Base64.getDecoder();
        byte[] decoderByteArray = decoder.decode(encoderString);
        System.out.println(new String(decoderByteArray));
    }

}

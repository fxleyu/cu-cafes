package fx.leyu.jdk.nio;

import java.nio.FloatBuffer;

// https://www.ibm.com/developerworks/cn/education/java/j-nio/j-nio.html
public class UseFloatBuffer {
    public static void main( String args[] ) throws Exception {
        FloatBuffer buffer = FloatBuffer.allocate( 10 );

        for (int i=0; i<buffer.capacity(); ++i) {
            //float f = (float)Math.sin( (((float)i)/10)*(2*Math.PI) );
            buffer.put( i );
        }

        // public Buffer flip() {
        //        limit = position;
        //        position = 0;
        //        mark = -1;
        //        return this;
        //  }
        buffer.flip();

        while (buffer.hasRemaining()) {
            float f = buffer.get();
            System.out.println( f );
        }
    }
}

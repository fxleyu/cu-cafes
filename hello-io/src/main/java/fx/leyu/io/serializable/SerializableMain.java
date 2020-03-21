package fx.leyu.io.serializable;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class SerializableMain {

    public static void main(String[] args) throws IOException {
        One one = new One();
        one.setName("fxleyu");
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //Hessian的序列化输出
        HessianOutput ho = new HessianOutput(os);
        ho.writeObject(one);

        byte[] userByte = os.toByteArray();
        ByteArrayInputStream is = new ByteArrayInputStream(userByte);


        //Hessian的反序列化读取对象
        HessianInput hi = new HessianInput(is);
        One u = (One) hi.readObject();
        System.out.println("name：" + u.getName());
        System.out.println("other：" + u.getOther());
    }

    public static class One implements Serializable {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOther() {
            return "fxyuer";
        }
    }
}

package fx.leyu.project.jdata2017;

import java.sql.Timestamp;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] arr = "80850,159187,2016-03-12 00:08:36,,6,5,225".split(",");
        System.out.println(Arrays.toString(arr));
        //System.out.println(Integer.parseInt(arr[3]));
        Timestamp s = Timestamp.valueOf("2016-03-12 00:08:36");
        System.out.println(s);
    }
    
}

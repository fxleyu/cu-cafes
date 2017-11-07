package fx.leyu.stackoverflow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SpecialDateTest {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String str3 = "1990-4-14 23:59:59";
        String str4 = "1990-4-15 1:0:0";
        Date sDt3 = sf.parse(str3);
        Date sDt4 = sf.parse(str4);
        System.out.println(sDt3);
        System.out.println(sDt4);
        long ld3 = sDt3.getTime() /1000;  
        long ld4 = sDt4.getTime() /1000;
        System.out.println(ld4-ld3);
        
        System.out.println(sDt4.toGMTString());      
        System.out.println(sDt3.toGMTString());
        
        System.out.println(TimeZone.getDefault());
    }

}

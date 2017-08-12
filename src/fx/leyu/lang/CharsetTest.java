package fx.leyu.lang;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class CharsetTest {

    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
        handleUtf8();
        handleGbk();
    }
    
    private static void handleGbk() throws FileNotFoundException, UnsupportedEncodingException {
        Scanner sc = new Scanner(new File("data/gbk.txt"), "gbk");
        byte[] bs = sc.nextLine().getBytes();
        sc.close();
        
        System.out.println(new String(bs));
    }

    private static void handleUtf8() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data/uft-8.txt"));
        byte[] bs = sc.nextLine().getBytes();
        sc.close();
        
        System.out.println(new String(bs));
    }

}
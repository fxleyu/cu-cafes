package fx.leyu.jdk.lang;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CharsetDemo {

    public static void main(String[] args) throws FileNotFoundException {
        int[] x = new int[2];
        for (int i = 0; i < x.length; i++) {
            x[i]++;
        }
        System.out.println(Arrays.toString(x));

        //handleUtf8();
        //handleGbk();
    }
    
    private static void handleGbk() throws FileNotFoundException {
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

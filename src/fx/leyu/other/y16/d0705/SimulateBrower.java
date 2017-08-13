package fx.leyu.other.y16.d0705;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class SimulateBrower {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.dominos.co.in/menu"); 
        //URLConnection connection = url.openConnection();
        
        
        HttpURLConnection httpUrlConnection = (HttpURLConnection)url.openConnection();
        
        System.out.println(httpUrlConnection.getHeaderField("Cache-Control"));
        System.out.println("******************************************");
        
        httpUrlConnection.connect();  
        
        Scanner scanner = new Scanner(httpUrlConnection.getInputStream());
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    public static void setRequestProperty(HttpURLConnection hc) {
        //httpUrlConnection.setRequestProperty("Content-type", "application/x-java-serialized-object"); 
        //httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
        hc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.154 Safari/537.36");  
        hc.setDoOutput(true);  
        //hc.setFollowRedirects(true); 
        hc.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");  
        hc.setRequestProperty("Content-Language", "zh-cn");  
        hc.setRequestProperty("Connection", "keep-alive");  
    }

}

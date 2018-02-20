package fx.leyu.other.y16.d0719;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class SimulateBrowerUseHttpClient {

    public static void main(String[] args) throws UnsupportedOperationException, IOException {
        @SuppressWarnings("resource")
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://www.dominos.co.in/menu");
        
        //setHeader(httpget);
        setHeaderError(httpget);
        
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instream = entity.getContent();
            Scanner scanner = new Scanner(instream, "UTF-8");
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

    private static void setHeaderError(HttpGet httpget) {
        httpget.setHeader("Connection", "keep-alive");
        httpget.setHeader("Cache-Control", "max-age=0");
        httpget.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        httpget.setHeader("Upgrade-Insecure-Requests", "1");
        httpget.setHeader("User-Agent", "Mozilla/5.0 (Linux; Android 5.1.1; ZTE Build/LMY47V) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.76 Mobile Safari/537.36");
        //httpget.setHeader("User-Agent", "Mozilla/5.0 (Linux; Android 5.1.1; ZTE BLADE Build/LMY47V) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.76 Mobile Safari/537.36");
        httpget.setHeader("Accept-Encoding", "deflate, sdch");
        httpget.setHeader("Accept-Languag", "en-US,en;q=0.8");
    }

    public static void setHeader(HttpGet httpget) {
        httpget.setHeader("Connection", "keep-alive");
        httpget.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        httpget.setHeader("Upgrade-Insecure-Requests", "1");
        httpget.setHeader("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; ZTE BLADE A910 Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.89 Mobile Safari/537.36");
        httpget.setHeader("Accept-Encoding", "gzip, deflate, sdch");
        httpget.setHeader("Accept-Languag", "zh-CN,zh;q=0.8");
    }

}

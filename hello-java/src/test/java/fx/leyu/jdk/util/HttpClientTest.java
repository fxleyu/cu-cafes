package fx.leyu.jdk.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import org.apache.http.HttpEntity;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.junit.Test;
import org.springframework.util.Base64Utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

public class HttpClientTest {

    @Test
    public void test() throws IOException {
        System.out.println(JSONObject.toJSONString(null));
        // 42a8f45bfa0aeefab3dc6bdcc393beaa-us8
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String apiKye = Base64Utils.encodeToString("anystring:42a8f45bfa0aeefab3dc6bdcc393beaa-us8".getBytes());
        HttpGet httpget = new HttpGet("https://us8.api.mailchimp.com/3.0/ping");
        httpget.addHeader("Authorization",  "Basic " + apiKye);
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
        } finally {
            response.close();
        }
    }

    @Test
    public void addStore() throws IOException {
        // 42a8f45bfa0aeefab3dc6bdcc393beaa-us8
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String apiKye = Base64Utils.encodeToString("anystring:42a8f45bfa0aeefab3dc6bdcc393beaa-us8".getBytes());
        HttpPost httpget = new HttpPost("https://us8.api.mailchimp.com/3.0/ecommerce/stores");

        Map<String, String> body = Maps.newHashMap();
        body.put("id", "URBANIC_001");
        body.put("list_id", "d1941c793c");
        body.put("name", "URBANIC_001");
        body.put("currency_code", "CNY");
        httpget.setEntity(new StringEntity(JSON.toJSONString(body)));
        httpget.addHeader("Authorization",  "Basic " + apiKye);
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
        } finally {
            response.close();
        }
    }

    @Test
    public void getAudiences() throws IOException {
        // 42a8f45bfa0aeefab3dc6bdcc393beaa-us8

        PoolingHttpClientConnectionManager connectionManager =
                new PoolingHttpClientConnectionManager(2, TimeUnit.MINUTES);
        connectionManager.setMaxTotal(50);//1.2
        connectionManager.setDefaultMaxPerRoute(50);//1.3
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials
                = new UsernamePasswordCredentials("anystring", "42a8f45bfa0aeefab3dc6bdcc393beaa-us8");
        provider.setCredentials(AuthScope.ANY, credentials);
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setCredentialsProvider(provider);


        CloseableHttpClient httpclient = HttpClients.custom()
                //.setConnectionManager(connectionManager)//2.1
                .setDefaultCredentialsProvider(provider)
                .setProxyAuthenticationStrategy(ProxyAuthenticationStrategy.INSTANCE)
                .setTargetAuthenticationStrategy(TargetAuthenticationStrategy.INSTANCE)
                //.setRetryHandler(new StandardHttpRequestRetryHandler())
                //.disableAuthCaching()//2.2
                .build();
        String apiKye = Base64Utils.encodeToString("anystring:42a8f45bfa0aeefab3dc6bdcc393beaa-us8".getBytes());
        HttpGet httpget = new HttpGet("https://us8.api.mailchimp.com/3.0/lists");

        Map<String, Object> body = Maps.newHashMap();
        body.put("id", "URBANIC_001");
        body.put("list_id", "URBANIC");
        body.put("name", "URBANIC_001");
        body.put("email_type_option", true);
        //httpget.setEntity(new StringEntity(JSON.toJSONString(body)));
        //httpget.addHeader("Authorization",  "Basic " + apiKye);
        for (int i = 0; i < 2; i++) {
            CloseableHttpResponse response = httpclient.execute(httpget, localContext);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    String result = EntityUtils.toString(entity);
                    System.out.println(result);
                }
            } finally {
                response.close();
            }
        }

    }

    @Test
    public void addAudiences() throws IOException {
        // 42a8f45bfa0aeefab3dc6bdcc393beaa-us8
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String apiKye = Base64Utils.encodeToString("anystring:42a8f45bfa0aeefab3dc6bdcc393beaa-us8".getBytes());
        HttpPost httpget = new HttpPost("https://us8.api.mailchimp.com/3.0/lists");

        Map<String, Object> body = Maps.newHashMap();
        body.put("id", "URBANIC_001");
        body.put("list_id", "URBANIC");
        body.put("name", "URBANIC_001");
        body.put("email_type_option", true);
        httpget.setEntity(new StringEntity(JSON.toJSONString(body)));
        httpget.addHeader("Authorization",  "Basic " + apiKye);
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
        } finally {
            response.close();
        }
    }

    @Test
    public void addUser() throws IOException {
        // 42a8f45bfa0aeefab3dc6bdcc393beaa-us8
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String apiKye = Base64Utils.encodeToString("anystring:42a8f45bfa0aeefab3dc6bdcc393beaa-us8".getBytes());
        HttpPost httpget = new HttpPost("https://us8.api.mailchimp.com/3.0/ecommerce/stores/URBANIC_001/customers");

        Map<String, Object> body = Maps.newHashMap();
        body.put("id", "fxleyu");
        body.put("email_address", "fxleyu@gmail.com");
        body.put("opt_in_status", true);
        //body.put("email_type_option", true);
        httpget.setEntity(new StringEntity(JSON.toJSONString(body)));
        httpget.addHeader("Authorization",  "Basic " + apiKye);
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
        } finally {
            response.close();
        }
    }

    @Test
    public void updateUser() throws IOException {
        // 42a8f45bfa0aeefab3dc6bdcc393beaa-us8
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String apiKye = Base64Utils.encodeToString("anystring:42a8f45bfa0aeefab3dc6bdcc393beaa-us8".getBytes());
        HttpPut httpget = new HttpPut("https://us8.api.mailchimp.com/3.0/ecommerce/stores/URBANIC_001/customers/fxleyuZ");

        Map<String, Object> body = Maps.newHashMap();
        body.put("id", "fxleyuZ");
        body.put("email_address", "fxleyu@urbanic.com");
        body.put("opt_in_status", true);
        //body.put("email_type_option", true);
        httpget.setEntity(new StringEntity(JSON.toJSONString(body)));
        httpget.addHeader("Authorization",  "Basic " + apiKye);
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
        } finally {
            response.close();
        }
    }


    @Test
    public void addProduct() throws IOException {
        // 42a8f45bfa0aeefab3dc6bdcc393beaa-us8
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String apiKye = Base64Utils.encodeToString("anystring:42a8f45bfa0aeefab3dc6bdcc393beaa-us8".getBytes());
        HttpPost httpget = new HttpPost("https://us8.api.mailchimp.com/3.0/ecommerce/stores/URBANIC_001/products");

        List<Object> variants = Lists.newArrayList();
        Map<String, Object> variant = Maps.newHashMap();
        variant.put("id", "79820-v1");
        variant.put("title", "lentejuelas");
        variants.add(variant);
        variant = Maps.newHashMap();
        variant.put("id", "79820-v2");
        variant.put("title", "plentejuelas");
        variants.add(variant);
        Map<String, Object> body = Maps.newHashMap();
        body.put("id", "79820");
        body.put("title", "Menor preço nos últimos 30 dias");
        body.put("variants", variants);
        httpget.setEntity(new StringEntity(JSON.toJSONString(body), APPLICATION_JSON));
        httpget.addHeader("Authorization",  "Basic " + apiKye);

        System.out.println(JSON.toJSONString(body));
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
        } finally {
            response.close();
        }
    }

    @Test
    public void deleteProduct() throws IOException {
        // 42a8f45bfa0aeefab3dc6bdcc393beaa-us8
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String apiKye = Base64Utils.encodeToString("anystring:42a8f45bfa0aeefab3dc6bdcc393beaa-us8".getBytes());
        HttpDelete httpget = new HttpDelete("https://us8.api.mailchimp.com/3.0/ecommerce/stores/URBANIC_001/products/productA");

        List<Object> variants = Lists.newArrayList();
        Map<String, Object> variant = Maps.newHashMap();
        variant.put("id", "productA-v3");
        variant.put("title", "SKU -v3");
        variants.add(variant);
        variant = Maps.newHashMap();
        variant.put("id", "productA-v4");
        variant.put("title", "SKU -v5");
        variants.add(variant);
        Map<String, Object> body = Maps.newHashMap();
        body.put("id", "productAB");
        body.put("title", "SKU -v2");

        body.put("variants", variants);
        //body.put("email_type_option", true);
        System.out.println(JSON.toJSONString(body));
        //httpget.setEntity(new StringEntity(JSON.toJSONString(body)));
        httpget.addHeader("Authorization",  "Basic " + apiKye);
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            System.out.println(response.getStatusLine());
            StatusLine statusLine = response.getStatusLine();
            System.out.println(statusLine.getStatusCode());
            HttpEntity entity = response.getEntity();
            System.out.println(JSON.toJSONString(response.getAllHeaders()));
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result + ":" + result.length());
            }
        } finally {
            response.close();
        }
    }

    @Test
    public void getProduct() throws IOException {
        // 42a8f45bfa0aeefab3dc6bdcc393beaa-us8
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String apiKye = Base64Utils.encodeToString("anystring:42a8f45bfa0aeefab3dc6bdcc393beaa-us8".getBytes());
        HttpGet httpget = new HttpGet("https://us8.api.mailchimp.com/3.0/ecommerce/stores/URBANIC_001/products/productA2");

        List<Object> variants = Lists.newArrayList();
        Map<String, Object> variant = Maps.newHashMap();
        variant.put("id", "productA-v1");
        variant.put("title", "Pantalones de pierna ancha de poliéster lentejuelas");
        variants.add(variant);
        variant = Maps.newHashMap();
        variant.put("id", "productA-v4");
        variant.put("title", "SKU -v5");
        variants.add(variant);
        Map<String, Object> body = Maps.newHashMap();
        body.put("id", "productA");
        body.put("title", "测试【BR】Biquíni de poliéster nó 3 peças/【MX】Precio Más Bajo En Los Últimos 30 Días");
        body.put("image_url", "https://img104.urbanic.com/goods-pic/f462916b27ad4514886c584aa3b44476");

        body.put("variants", variants);
        //httpget.setEntity(new StringEntity(JSON.toJSONString(body), APPLICATION_JSON));
        httpget.addHeader("Authorization",  "Basic " + apiKye);

        System.out.println(JSON.toJSONString(httpget));
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity, "UTF-8");
                System.out.println(result);
            }
        } finally {
            response.close();
        }
    }

    @Test
    public void updateProduct() throws IOException {
        // 42a8f45bfa0aeefab3dc6bdcc393beaa-us8
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String apiKye = Base64Utils.encodeToString("anystring:42a8f45bfa0aeefab3dc6bdcc393beaa-us8".getBytes());
        HttpPatch httpget = new HttpPatch("https://us8.api.mailchimp.com/3.0/ecommerce/stores/URBANIC_001/products/productA");

        List<Object> variants = Lists.newArrayList();
        Map<String, Object> variant = Maps.newHashMap();
        variant.put("id", "productA-v1");
        variant.put("title", "Pantalones de pierna ancha de poliéster lentejuelas");
        variants.add(variant);
        variant = Maps.newHashMap();
        variant.put("id", "productA-v4");
        variant.put("title", "SKU -v5");
        variants.add(variant);
        Map<String, Object> body = Maps.newHashMap();
        body.put("id", "productA");
        body.put("title", "测试【BR】Biquíni de poliéster nó 3 peças/【MX】Precio Más Bajo En Los Últimos 30 Días");
        body.put("image_url", "https://img104.urbanic.com/goods-pic/f462916b27ad4514886c584aa3b44476");

        body.put("variants", variants);
        httpget.setEntity(new StringEntity(JSON.toJSONString(body), APPLICATION_JSON));
        httpget.addHeader("Authorization",  "Basic " + apiKye);

        System.out.println(JSON.toJSONString(httpget));
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity, "UTF-8");
                System.out.println(result);
            }
        } finally {
            response.close();
        }
    }

    @Test
    public void addCart() throws IOException {
        // 42a8f45bfa0aeefab3dc6bdcc393beaa-us8
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String apiKye = Base64Utils.encodeToString("anystring:42a8f45bfa0aeefab3dc6bdcc393beaa-us8".getBytes());
        HttpPost httpget = new HttpPost("https://us8.api.mailchimp.com/3.0/ecommerce/stores/URBANIC_001/carts");

        List<Object> lines = Lists.newArrayList();
        Map<String, Object> line = Maps.newHashMap();
        line.put("id", "productA-v1");
        line.put("product_id", "productA");
        line.put("product_variant_id", "productA-v1");
        line.put("quantity", 1);
        line.put("price", 12);
        lines.add(line);

        Map<String, Object> consumtor = Maps.newHashMap();
        consumtor.put("id", "fxleyuZ");
        Map<String, Object> body = Maps.newHashMap();
        body.put("id", "cart-v1-fxleyu");
        body.put("customer", consumtor);
        body.put("currency_code", "CNY");
        body.put("order_total", 12);
        body.put("lines", lines);

        //body.put("email_type_option", true);
        httpget.setEntity(new StringEntity(JSON.toJSONString(body)));

        System.out.println(JSON.toJSONString(body));
        httpget.addHeader("Authorization",  "Basic " + apiKye);
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
        } finally {
            response.close();
        }
    }

    @Test
    public void updateCart() throws IOException {
        // 42a8f45bfa0aeefab3dc6bdcc393beaa-us8
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String apiKye = Base64Utils.encodeToString("anystring:42a8f45bfa0aeefab3dc6bdcc393beaa-us8".getBytes());
        HttpPatch httpget = new HttpPatch("https://us8.api.mailchimp.com/3.0/ecommerce/stores/URBANIC_001/carts/cart-v1-fxleyu");

        List<Object> lines = Lists.newArrayList();
        Map<String, Object> line = Maps.newHashMap();
        line.put("id", "productA-v1");
        line.put("product_id", "productA");
        line.put("product_variant_id", "productA-v1");
        line.put("quantity", 1);
        line.put("price", 12);
        lines.add(line);

        Map<String, Object> consumtor = Maps.newHashMap();
        consumtor.put("id", "fxleyuZ");
        Map<String, Object> body = Maps.newHashMap();
        body.put("id", "cart-v1-fxleyu");
        body.put("customer", consumtor);
        body.put("currency_code", "CNY");
        body.put("order_total", 12);
        body.put("lines", lines);

        //body.put("email_type_option", true);
        httpget.setEntity(new StringEntity(JSON.toJSONString(body)));

        System.out.println(JSON.toJSONString(body));
        httpget.addHeader("Authorization",  "Basic " + apiKye);
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
        } finally {
            response.close();
        }
    }

    @Test
    public void deleteCart() throws IOException {
        // 42a8f45bfa0aeefab3dc6bdcc393beaa-us8
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String apiKye = Base64Utils.encodeToString("anystring:42a8f45bfa0aeefab3dc6bdcc393beaa-us8".getBytes());
        HttpDelete httpget = new HttpDelete("https://us8.api.mailchimp.com/3.0/ecommerce/stores/URBANIC_001/carts/cart-v1-fxleyu");

        List<Object> lines = Lists.newArrayList();
        Map<String, Object> line = Maps.newHashMap();
        line.put("id", "productA-v1");
        line.put("product_id", "productA");
        line.put("product_variant_id", "productA-v1");
        line.put("quantity", 1);
        line.put("price", 12);
        lines.add(line);

        Map<String, Object> consumtor = Maps.newHashMap();
        consumtor.put("id", "fxleyuZ");
        Map<String, Object> body = Maps.newHashMap();
        body.put("id", "cart-v1-fxleyu");
        body.put("customer", consumtor);
        body.put("currency_code", "CNY");
        body.put("order_total", 12);
        body.put("lines", lines);

        //body.put("email_type_option", true);
        //httpget.setEntity(new StringEntity(JSON.toJSONString(body)));

        //System.out.println(JSON.toJSONString(body));
        httpget.addHeader("Authorization",  "Basic " + apiKye);
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            System.out.println(JSON.toJSONString(response));
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
        } finally {
            response.close();
        }
    }
}

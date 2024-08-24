package com.jdktomcat.pack.net;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 类描述：测试类
 *
 * @author 11072131
 * @date 2020-04-2020/4/7 16:32
 */
public class UrlTest {

    public static void main(String[] args) throws IOException {
        String urlStr = "http://www.tatum.com";
        URL url = new URL(urlStr);
        URLConnection urlConnection = url.openConnection();
        urlConnection.getInputStream();
        urlConnection.connect();
    }
}

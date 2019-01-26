package com.core.common;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-9-9
 * Time: 上午10:01
 * To change this template use File | Settings | File Templates.
 */
public class HttpClientHelper {

    public static String httpClientGet(String url) throws IOException, URISyntaxException, HttpException {
        String responseBody;
        @SuppressWarnings({ "resource", "deprecation" })
        HttpClient httpclient = new DefaultHttpClient();
        try {
            HttpGet httpget = new HttpGet(url);
            HttpEntity httpEntity = httpclient.execute(httpget).getEntity();
            responseBody = EntityUtils.toString(httpEntity, "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            httpclient.getConnectionManager().shutdown();
        }
        return responseBody;
    }

}

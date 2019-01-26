package com.core.common;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-9-9
 * Time: 上午9:43
 * To change this template use File | Settings | File Templates.
 */
public class GetDataUtil {
    // 构造一个缓存管理器
    public static ConcurrentHashMap<String, Object> dkCacheManager = new ConcurrentHashMap<String, Object>();

    /**
     * dk缓存机制
     * @param url
     * @return
     */
    public static JSONArray getData(String url) throws HttpException, IOException, URISyntaxException {
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date=new Date();
        String nowDate=sf.format(date);
        JSONArray dataSource=new JSONArray();
        //缓存里面的取取url,只要重复的url就从缓存里面取
        JSONObject cache = (JSONObject) dkCacheManager.get(url);
        if (cache != null) {    // 如果在缓存中，则直接返回缓存的结果
            //如果缓存中， //超过15分钟的缓存清空
            String history=cache.getString("time");
            try {
                if(sf.parse(nowDate).getTime()>sf.parse(history).getTime()&&(sf.parse(nowDate).getTime()-sf.parse(history).getTime())>15*60000){
                    dkCacheManager.remove(url);//删除缓存，从数据库直接查找
                    String jsonStr = HttpClientHelper.httpClientGet(url);
                    if (jsonStr != null)
                        dataSource = JSONUtil.strToArr(jsonStr);
                    if(dataSource!=null&&dataSource.size()>0){
                        JSONObject jsonObject=new JSONObject();
                        jsonObject.put("time",nowDate);
                        jsonObject.put("data",dataSource);
                        dkCacheManager.put(url, jsonObject);
                        return dataSource;
                    }

                }else{
                    return cache.getJSONArray("data");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return dataSource;
        } else {  // 否则到数据库中查询
            String jsonStr = HttpClientHelper.httpClientGet(url);
            if (jsonStr != null)
                dataSource = JSONUtil.strToArr(jsonStr);
            if(dataSource!=null&&dataSource.size()>0){
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("time",nowDate);
                jsonObject.put("data",dataSource);
                dkCacheManager.put(url, jsonObject);     // 将数据库查询的结果更新到缓存中
            }
            return dataSource;
        }
    }

    public static void clearCache(){
        dkCacheManager.clear();
    }
}

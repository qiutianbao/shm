package com.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GetDataUtil {
    // 构造一个缓存管理器
    public static HashMap<String, Object> dkCacheManager = new HashMap<String, Object>();

    /**
     * dk缓存机制
     * @param url
     * @return
     */
    public static JSONArray getData(String url) {
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
                if(sf.parse(nowDate).getTime()>sf.parse(history).getTime()&&(sf.parse(nowDate).getTime()-sf.parse(history).getTime())>2*60000){
                    dkCacheManager.remove(url);//删除缓存，从数据库直接查找
                    String jsonStr = HttpClientUtil.getHttpclient(url);
                    if (jsonStr != null)
                        dataSource = JsonUtil.strToArr(jsonStr);
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
            String jsonStr = HttpClientUtil.getHttpclient(url);
            if (jsonStr != null)
                dataSource = JsonUtil.strToArr(jsonStr);
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




    /*
     * url:请求的DK的URL fieldmap:字段列表 example:{"产能":"Capacity","产量":"Production"}
     */
    public static String getEchartsData(String url, Map<String, String> fieldmap) {
        String arr = null;
        JSONArray dataStr = getData(url);
        if (dataStr != null) {
            int valueSize = dataStr.size();
            int n = fieldmap.size();
            int i = 0;
            String[] legend = new String[n];
            Map<String, Object> valmap = new HashMap<String, Object>();
            Iterator<Entry<String, String>> iter = fieldmap.entrySet().iterator();
            while (iter.hasNext()) {
                Entry<String, String> entry = (Entry<String, String>) iter.next();
                String key = entry.getKey();
                String val = entry.getValue();
                legend[i] = key;
                i++;

                String[] valarr = new String[valueSize];
                for (int j = 0; j < valueSize; j++) {
                    valarr[j] = null;
                    JSONObject object = (JSONObject) dataStr.get(j);
                    String data = object.getString(val);
                    valarr[j] = data;
                }
                valmap.put(val, valarr);
            }
            valmap.put("legend", legend);
            arr = JsonUtil.map2json(valmap);
        }
        return arr;
    }

}

package com.core.common;

import net.sf.json.JSONArray;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-9-9
 * Time: 上午9:45
 * To change this template use File | Settings | File Templates.
 */
public class JSONUtil {
    private static Logger LOGGER = Logger.getLogger(JSONUtil.class);

    public static JSONArray strToArr(String jsonStr) {
        JSONArray dataArr = null;
        try {
            jsonStr = jsonStr.replaceAll("\r\n", "<br/>")
                    .replaceAll("\r", "<br/>")
                    .replaceAll("\n", "<br/>");

            if (!"\u007F".equals(jsonStr)) {
                net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(jsonStr);
                String responseStr = jsonObject.getString("response");
                net.sf.json.JSONObject responseJsonObject = net.sf.json.JSONObject.fromObject(responseStr);

                boolean isDataReturn = responseJsonObject.containsKey("data");
                String dataStr = "";
                if (isDataReturn)
                    dataStr = responseJsonObject.getString("data");
                boolean isError = responseJsonObject.containsKey("error");

                if (isError == false) {
                    dataArr = JSONArray.fromObject(dataStr);
                    if(dataArr!=null){
                        dataArr.add(0,responseJsonObject.get("total"));
                    }
                }
            }

        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        }
        return dataArr;
    }

}

package com.core.velocity;

import com.core.support.BaseActionSupport;
import com.util.HttpClientUtil;
import com.util.JsonUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-30
 * Time: 下午12:33
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
public class velocityVm extends BaseActionSupport {

    /**
     *  生成velocity模板
     * @param dkServiceUrl
     * @param name
     * @param pindex
     * @param currentPage   当前页
     * @param maxPage  最大页面，总记录数 total
     */
    public void velocityJsp(String dkServiceUrl,int currentPage,String maxPage,String vmName,String jsonArrayName) {
        Properties p = new Properties();

        p.setProperty("file.resource.loader.class", ClasspathResourceLoader.class.getName());
        // 设置编码
        p.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        // VelocityEngine   是单例模式
        VelocityEngine velocityEngine = new VelocityEngine(p);
        velocityEngine.init();
        Template template = velocityEngine.getTemplate(vmName+".vm");

        VelocityContext ctx = new VelocityContext();
        //获取所以数据
        ctx = getAllCtxData(ctx, dkServiceUrl,currentPage,maxPage,vmName,jsonArrayName);

        //生成模板

        String path= Thread.currentThread().getContextClassLoader().getResource("").getPath().replace("/WEB-INF/classes", "") + "/static/" + vmName + ".html";

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
            template.merge(ctx, bw);
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //返回VelocityContext对象
    public VelocityContext getAllCtxData(VelocityContext ctx,String dkServiceUrl,int currentPage,String maxPage,String vmName,String jsonArrayName) {
        JSONArray jsonArray = getAllData(ctx, dkServiceUrl, currentPage, maxPage, vmName);
        if (jsonArray != null) {
            ctx.put(jsonArrayName,jsonArray);
        }
        return ctx;
    }

    //获取数据
    public JSONArray getAllData(VelocityContext ctx,String dkServiceUrl,int currentPage,String maxPage,String vmName) {
        String jsonStr = HttpClientUtil.getHttpclient(dkServiceUrl);
        JSONArray arr = new JSONArray();
        try {
            if (jsonStr != null) {
                JSONObject jsonObject = JSONObject.fromObject(jsonStr);
                String responseStr = jsonObject.getString("response");
                JSONObject responseJsonObject = JSONObject.fromObject(responseStr);

                maxPage = responseJsonObject.get("ptotal").toString();
                ctx.put("maxPage",maxPage);
                ctx.put("vmName", vmName);

                if (responseJsonObject != null) {
                    boolean isDataReturn = responseJsonObject.containsKey("data");
                    String dataStr = "";
                    boolean isError = false;
                    if (isDataReturn) {
                        dataStr = responseJsonObject.getString("data");
                        arr = JsonUtil.strToArr(jsonStr);
                    } else {
                        isError = responseJsonObject.containsKey("error");
                    }
                    if (!isError && isDataReturn) {

                        totalRows = Integer.valueOf(responseJsonObject.getString("total"));
                        totalPage = Integer.valueOf(responseJsonObject.getString("ptotal"));
                        maxPage=responseJsonObject.getString("ptotal");
                        super.setTotalPage(totalPage);
                        ctx.put("totalRows", totalRows);
                        ctx.put("totalPage", totalPage);
                        ctx.put("currentPage", currentPage);
                        ctx.put("maxpage",maxPage);

                    }

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arr;
    }

}

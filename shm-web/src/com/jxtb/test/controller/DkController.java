package com.jxtb.test.controller;

import com.jxtb.test.service.IDkService;
import com.util.GetDataUtil;
import com.util.ReadDkProperties;
import com.util.WebServiceConfigs;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-23
 * Time: 下午2:26
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Controller
@RequestMapping("dk")
public class DkController {

    // 业务层
    @Resource(name = "dkService")
    private IDkService dkService;

    @Resource
    private WebServiceConfigs webServiceConfigs;

    public void setWebServiceConfigs(WebServiceConfigs webServiceConfigs) {
        this.webServiceConfigs = webServiceConfigs;
    }

    //测试dk
    @RequestMapping("/testDkReader")
    public String testDkReader(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        JSONObject jsonObjectModel=new JSONObject();
        try{
            //查询所有品目对应的模块
            String allProductModuleUrl = ReadDkProperties.getDkUrl("12000311", 1, 10000);
            if(allProductModuleUrl!=null){
                JSONArray allProductModule = GetDataUtil.getData(allProductModuleUrl);
                jsonObjectModel.put("allProductModule",allProductModule);
            }
            response.getWriter().print(jsonObjectModel);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "index";
    }

    //测试dk
    @RequestMapping("/testWS")
    public String testWebServiceConfigs(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        JSONObject jsonObjectModel=new JSONObject();
        try{
            //查询所有品目对应的模块
            String allProductModuleUrl= webServiceConfigs.getDkServiceUrl("12000311", 1, 10000);
            if(allProductModuleUrl!=null){
                JSONArray allProductModule = GetDataUtil.getData(allProductModuleUrl);
                jsonObjectModel.put("allProductModule",allProductModule);
            }
            response.getWriter().print(jsonObjectModel);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "index";
    }

    //测试dk
    @RequestMapping("/testDk")
    public String testDk(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        JSONObject jsonObjectModel=new JSONObject();
        try{
            //查询所有品目对应的模块
            String allProductModuleUrl=dkService.getDkUrl("12000311", 1, 10000);
            if(allProductModuleUrl!=null){
                JSONArray allProductModule = GetDataUtil.getData(allProductModuleUrl);
                jsonObjectModel.put("allProductModule",allProductModule);
            }
            response.getWriter().print(jsonObjectModel);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "index";
    }


}

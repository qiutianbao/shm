package com.jxtb.test.controller;

import com.core.velocity.velocityVm;
import com.util.GetDataUtil;
import com.util.ReadDkProperties;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-30
 * Time: 下午2:57
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Controller
@RequestMapping("velocity")
public class velocityVmController {
    //测试dk
    @RequestMapping("/vm")
    public String testDkReader(HttpServletRequest request, HttpServletResponse response) throws ServletException,Exception {
        //查询所有品目对应的模块
        String dkServiceUrl= ReadDkProperties.getDkUrl("12000311", 1, 10000);
        int currentPage=1;
        String maxPage="1";
        String vmName="velocityTestIndex";
        String jsonArrayName="jsonArray";
        velocityVm vm=new velocityVm();
        vm.velocityJsp(dkServiceUrl,currentPage,maxPage,vmName,jsonArrayName);
        request.setAttribute("vmName",vmName);      //请求对于的模板页面
        return "vm/returnToHtml";
    }



}

package com.jxtb.test.controller;

import com.util.GetDataUtil;
import com.util.ReadDkProperties;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-28
 * Time: 上午10:38
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Controller
@RequestMapping("springmvc")
@SessionAttributes({"u","a"})  //将ModelMap中属性名字为u、a的再放入session中。这样，request和session中都有了。
public class TestController {

    //http://localhost:8085/springmvc/test/1.do?userName=admin&userPwd=admin
    //http://localhost:8085/springmvc/test/1.do?userName=admin&userPwd=admin&sex=%E7%94%B7

    /**
     *    <h1>${requestScope.u}</h1>
        <h1>${sessionScope.u}</h1>
     */
    @RequestMapping("/test/{page}")
    public String testDkReader(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap,
                               @RequestParam("userName") String userName,@RequestParam("userPwd") String userPwd, @PathVariable int page) throws ServletException,Exception {
        modelMap.addAttribute("u","中国"); //将u放入request作用域中，这样转发页面也可以取到这个数据。
        //java防SQL注入html编码入侵特殊字符转义和方法入参检测工具
        page=Integer.valueOf(HtmlUtils.htmlEscape(page+""));
        userName= HtmlUtils.htmlEscape(userName);
        userPwd= HtmlUtils.htmlEscape(userPwd);
        String  sex=request.getParameter("sex");
        if(!"".equals(sex) && null!=sex){
            sex=new String(sex.getBytes("ISO-8859-1"),"utf-8");
        }
        System.out.println("page="+page+",userName="+userName+",userPwd="+userPwd+",sex="+sex);
        return "login";
    }


    @RequestMapping(value = "/myActive", method = {RequestMethod.GET, RequestMethod.POST})
    public String myActive(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String userName=request.getParameter("userName");
        String passWord=request.getParameter("passWord");
        try{
            response.setContentType("text/html");
            response.getWriter().println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            response.getWriter().println("<HTML>");
            response.getWriter().println("  <HEAD><TITLE>jxtb-吉祥天宝</TITLE></HEAD>");
            response.getWriter().println("  <BODY>");
            if(userName.equals("admin") && passWord.equals("123456")){
                response.getWriter().print("欢迎您，admin!!!哈哈哈哈哈。。。。");
            }else{
                response.getWriter().print("密码错了，笨蛋！！！");
            }
            response.getWriter().println("  </BODY>");
            response.getWriter().println("</HTML>");
            response.getWriter().flush();
            response.getWriter().close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "login";
    }

}

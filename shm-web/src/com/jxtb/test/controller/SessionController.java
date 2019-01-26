package com.jxtb.test.controller;

import com.jxtb.test.entity.Test;
import com.jxtb.test.service.ISessionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-24
 * Time: 下午5:09
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Controller
@RequestMapping("session")
public class SessionController {

    // 业务层
    @Resource(name = "sessionService")
    private ISessionService sessionService;

    @RequestMapping("find")
    public String find(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<Test> testList= sessionService.findAllTest();
        Test test=sessionService.findTestById("5");
        System.out.println("testList="+testList);
        System.out.println("test="+test);
        return "login";
    }

    @RequestMapping("add")
    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Test test=new Test();
        test.setId("5");
        test.setUserName("abc123");
        test.setUserPsw("admin");
        int result= sessionService.addAllTest(test);
        System.out.println("result="+result);
        return "login";
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Test test=sessionService.findTestById("5");
        int result= sessionService.deleteAllTest(test);
        System.out.println("result="+result);
        return "login";
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Test test=sessionService.findTestById("5");
        test.setUserName("mimimi");
        test.setUserPsw("mimimi");
        int result= sessionService.updateAllTest(test);
        System.out.println("result="+result);
        return "login";
    }

}

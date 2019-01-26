package com.jxtb.test.controller;

import com.jxtb.test.entity.Test;
import com.jxtb.test.service.ISSTService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 下午1:39
 * sqlSessionTemplate
 */
@SuppressWarnings("ALL")
@Controller
@RequestMapping("sst")
public class SSTController {

    @Resource(name = "isstService")
    private ISSTService isstService;

    @RequestMapping("find")
    public String find(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<Test> testList= isstService.findAllTest();
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("id","5");
        Test test=isstService.queryTestById(map);
        System.out.println("testList="+testList);
        System.out.println("test="+test);

        List<Map<String, Object>> mapList=isstService.showAllTest(map);
        int total=isstService.searchTestTotal(map);
        System.out.println("mapList==="+mapList);
        System.out.println("total==="+total);

        return "login";
    }

    @RequestMapping("add")
    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Test test=new Test();
        test.setId("5");
        test.setUserName("abc123");
        test.setUserPsw("admin");
        //int result= isstService.savTest(test);
        int result= isstService.insertTestInfo(test);
        System.out.println("result="+result);
        return "login";
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("id","5");
        Test test=isstService.queryTestById(map);
        //int result= isstService.deleteTest(test);
        int result= isstService.deleteTestInfo(test);
        System.out.println("result="+result);
        return "login";
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("id","5");
        Test test=isstService.queryTestById(map);
        test.setUserName("mimimi");
        test.setUserPsw("mimimi");
        //int result= isstService.updateTest(test);
        int result= isstService.updateTestInfo(test);
        System.out.println("result="+result);
        return "login";
    }

}

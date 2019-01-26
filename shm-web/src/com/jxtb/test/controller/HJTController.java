package com.jxtb.test.controller;

import com.jxtb.test.entity.Test;
import com.jxtb.test.service.IHJTemplateService;
import com.jxtb.test.support.HDSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-23
 * Time: 下午4:22
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Controller
@RequestMapping("hjt")
public class HJTController {

    @Resource(name = "hjTemplateService")
    private IHJTemplateService IHJTemplateService;

    private HDSupport hdSupport;

    public HDSupport getHdSupport() {
        return hdSupport;
    }

    public void setHdSupport(HDSupport hdSupport) {
        this.hdSupport = hdSupport;
    }

    /**
     * jdbcTemplate
     */

    @RequestMapping("jt")
    public String jTemplate(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<Map<String, Object>> mapList= IHJTemplateService.selectJdbcTestList("5");
        List<Test> list= IHJTemplateService.findAllTest();
        String userName= IHJTemplateService.searchUserNameById("5");
        Test test= IHJTemplateService.searchJdbcTestById("5");
        System.out.println(mapList);
        System.out.println(list);
        System.out.println(userName);
        System.out.println(test);
        return "login";
    }

    @RequestMapping("jTAdd")
    public String jTAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Test test=new Test();
        test.setId("5");
        test.setUserName("abc123");
        test.setUserPsw("admin");
        int result= IHJTemplateService.addJdbcTest(test);
        System.out.println("result="+result);
        return "login";
    }

    @RequestMapping("jTDelete")
    public String jTDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Test test=new Test();
        test.setId("5");
        int result= IHJTemplateService.deleteJdbcTest(test);
        System.out.println("result="+result);
        return "login";
    }

    @RequestMapping("jTUpdate")
    public String jTUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Test test=new Test();
        test.setId("5");
        test.setUserName("mimimi");
        test.setUserPsw("mimimi");
        int result= IHJTemplateService.updateJdbcTest(test);
        System.out.println("result="+result);
        return "login";
    }

    /**
     * HibernateTemplate
     */

    @RequestMapping("ht")
    public String hTemplate(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<Test> testList= IHJTemplateService.selectHibernateTestList();
        Test test= IHJTemplateService.searchHibernateTestById("5");
        System.out.println(testList);
        System.out.println(test);
        return "login";
    }

    @RequestMapping("hTAdd")
    public String hTAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Test test=new Test();
        test.setId("5");
        test.setUserName("abc123");
        test.setUserPsw("admin");
       int result= IHJTemplateService.addHibernateTest(test);
        System.out.println(result);
        return "login";
    }

    @RequestMapping("hTUpdate")
    public String hTUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Test test=new Test();
        test.setId("5");
        test.setUserName("mimimi");
        test.setUserPsw("mimimi");
        int result= IHJTemplateService.updateHibernateTest(test);
        System.out.println(result);
        return "login";
    }

    @RequestMapping("hTDelete")
    public String hTDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Test test= IHJTemplateService.searchHibernateTestById("5");
        int result= IHJTemplateService.deleteHibernateTestById(test);
        System.out.println(result);
        return "login";
    }



    @RequestMapping("hdSupport")
    public String hdSupport(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<Test> list= hdSupport.findAll();
        Test test= hdSupport.queryTestById("5");
        System.out.println("lsit==="+list);
        System.out.println("test==="+test);
        return "login";
    }

    @RequestMapping("hsAdd")
    public String hsAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Test test=new Test();
        test.setId("5");
        test.setUserName("abc123");
        test.setUserPsw("admin");
        int result= hdSupport.saveTest(test);
        System.out.println(result);
        return "login";
    }

    @RequestMapping("hsUpdate")
    public String hsUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Test test=new Test();
        test.setId("5");
        test.setUserName("mimimi");
        test.setUserPsw("mimimi");
        int result= hdSupport.updateTest(test);
        System.out.println(result);
        return "login";
    }

    @RequestMapping("hsDelete")
    public String hsDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Test test= hdSupport.queryTestById("5");
        int result= hdSupport.deleteTest(test);
        System.out.println(result);
        return "login";
    }

}

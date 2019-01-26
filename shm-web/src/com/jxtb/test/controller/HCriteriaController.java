package com.jxtb.test.controller;

import com.jxtb.test.entity.Test;
import com.jxtb.test.service.IHCriteriaService;
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
 * Date: 17-3-27
 * Time: 下午4:52
 * hibernate Criteria查询
 */
@SuppressWarnings("ALL")
@Controller
@RequestMapping("hCriteria")
public class HCriteriaController {
    // 业务层
    @Resource(name = "hCriteriaService")
    private IHCriteriaService hCriteriaService;

    @RequestMapping("find")
    public String find(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<Test> testList= hCriteriaService.findAllTest();
        for(Test test:testList){
            System.out.println(test);
        }
        System.out.println("result="+testList);
        return "login";
    }

}

package com.jxtb.sys.controller;

import com.jxtb.sys.model.SysUser;
import com.jxtb.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-1-19
 * Time: 下午4:53
 * 登录
 */
@Controller
public class LoginController {

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException {
     /*   List<SysUser> sysUserList=sysUserService.getAll();
        if(sysUserList !=null && sysUserList.size()>0){
            for(int i=0;i<sysUserList.size();i++){
                SysUser sysUser=sysUserList.get(i);
                System.out.println(sysUser.getId());
                System.out.println(sysUser.getUserName());
                System.out.println(sysUser.getUserPsw());
            }
        }*/
        return "login";
    }

    @RequestMapping("register")
    public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        SysUser sysUser=new SysUser();
        sysUser.setId("4");
        sysUser.setUserName("梦玲");
        sysUser.setUserPsw("mengling");
        int result= (int) sysUserService.insert(sysUser);
        System.out.println(result);
        return "login";
    }

    @RequestMapping("reSetPwd")
    public String reSetPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        SysUser sysUser=new SysUser();
        sysUser.setId("4");
        sysUser.setUserName("梦灵");
        sysUser.setUserPsw("liaoliao");
        int result= sysUserService.update(sysUser);
        System.out.println(result);
        return "login";
    }

    @RequestMapping("deleteUser")
    public String deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Map<String,Object> param=new HashMap<>();
        param.put("id",3);
        int result= sysUserService.delete(param);
        System.out.println(result);
        return "login";
    }

}

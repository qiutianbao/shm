package com.jxtb.test.action;

import com.core.support.BaseActionSupport;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 下午6:08
 * To change this template use File | Settings | File Templates.
 */
public class TestAction extends BaseActionSupport{

   private String username="jxtb";
   private  String password="jxtb";

    public void testAction(){
        List list=new ArrayList();
        list.add("abc");
        list.add("123");

        //request:
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("list", list);

        //session:
        HttpSession session=request.getSession();
        session.setAttribute("list",list);

        //ServletContext:
        ServletContext context=ServletActionContext.getServletContext();
        context.setAttribute("list",list);


        String id="中文";
        try {
            id=new String(id.getBytes("ISO-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String loginAction(){
        String username="jxtb";
        String password="jxtb";
        if("jxtb".equals(username) && "jxtb".equals(password)) {

          /*  Map<String,Object> session = ActionContext.getContext().getSession();
            if(session.containsKey(CURRENT_USER)) {
                session.remove(CURRENT_USER);
            }
            session.put(CURRENT_USER, username);*/

            HttpSession session= ServletActionContext.getRequest().getSession();
            if(session.getAttribute(CURRENT_USER) != null) {
                session.removeAttribute(CURRENT_USER);
            }
            session.setAttribute(CURRENT_USER, username);

            return LOGIN;
        } else {
            return INPUT;
        }
    }

    public void validate() {
        if(this.getUsername().length()==0){
            addFieldError("name","用户名不能为空");
        }
        if(this.getPassword().length()==0){
            addFieldError("pwd", "密码不能为空");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

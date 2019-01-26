package com.jxtb.test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxtb.test.entity.AjaxJson;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Result;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-28
 * Time: 下午1:39
 * To change this template use File | Settings | File Templates.
 */
public class AjaxJsonAction extends ActionSupport implements Result{

    private AjaxJson admin;

    private String message;
    public String execute() throws Exception {

        if("admin".equals(admin.getUsername()) & "admin".equals(admin.getPassword())){

            message = "登陆成功!";

        }else {

            message = "用户名/密码有误!";

        }

        return Action.SUCCESS;

    }


    /**
     * 出来乱码问题
     */
    public void execute(ActionInvocation invocation) throws Exception {

        ActionContext cxt = invocation.getInvocationContext();
        HttpServletResponse response = (HttpServletResponse) cxt
                .get(StrutsStatics.HTTP_RESPONSE);
        //HttpServletRequest request=(HttpServletRequest)cxt.get(StrutsStatics.HTTP_REQUEST);
        response.setContentType("text/xml;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
    }

    public String ajaxGet(){

        return SUCCESS;
    }

    public String ajaxPost(){

        return SUCCESS;
    }

    public String getInfo(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String uname = request.getParameter("uname");
        request.setAttribute("uname",uname);
        return SUCCESS;
    }

    public String jsonInfo(){

        return SUCCESS;
    }

    public String jsonLogin(){
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("uname",admin);
        return SUCCESS;
    }

    public String load(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String uname = request.getParameter("uname");
        request.setAttribute("uname",uname);
        return SUCCESS;
    }

    public String login(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        request.setAttribute("name",name);
        request.setAttribute("pwd",pwd);
        return SUCCESS;
    }

    public String post(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String uname = request.getParameter("uname");
        request.setAttribute("uname",uname);
        return SUCCESS;
    }

    public AjaxJson getAdmin() {
        return admin;
    }

    public void setAdmin(AjaxJson admin) {
        this.admin = admin;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


package com.core.web.filter;

import com.core.web.SessionThreadLocal;
import com.jxtb.sys.model.SysUser;
import com.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-1-18
 * Time: 上午11:18
 * 登录拦截
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String contextPath=request.getContextPath();
        String url=request.getRequestURI();
        url=url.replace(contextPath,"");
        if(!url.startsWith("/login") && !url.startsWith("/register") && !url.startsWith("/forgotPwd") && !url.startsWith("/index")){
            SysUser sysUser=(SysUser)request.getSession().getAttribute(Constant.SESSION_SYS_USER);
            if(sysUser==null){
                response.sendRedirect(contextPath+"login");
                return;
            }
            //解决多线程程序的并发
            SessionThreadLocal.setThreadSysUser(sysUser);
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}

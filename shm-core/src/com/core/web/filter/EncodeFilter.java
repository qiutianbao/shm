package com.core.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 下午4:08
 * 过滤器File处理中文乱码
 */
public class EncodeFilter implements Filter{

    private String encode = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String encode = filterConfig.getInitParameter("encode");
        if (this.encode == null) {
            this.encode = encode;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding(encode);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        encode = null;
    }
}

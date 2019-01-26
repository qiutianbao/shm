package com.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-29
 * Time: 下午2:21
 * To change this template use File | Settings | File Templates.
 */
public class BaseController extends MultiActionController {

    protected final Log log = LogFactory.getLog(this.getClass());

    protected void setSessionObject(HttpServletRequest request,String key,Object obj){
        request.getSession().setAttribute(key, obj);
    }

    protected Object getSessionObject(HttpServletRequest request,String key){
        return request.getSession().getAttribute(key);
    }

}

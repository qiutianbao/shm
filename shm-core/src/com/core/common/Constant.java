package com.core.common;



import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-9-9
 * Time: 上午9:11
 * To change this template use File | Settings | File Templates.
 */
public class Constant {

    /**
     * 配置文件里的值
     */
    public static Properties props = new Properties();

    public static final String SESSION_SYS_USER = "SESSION_SYS_USER";

    public static  String appKey = "ACM";

    public static  String secret = "7B92988F00B346709A8BEC9CC513859F";

    /**
     * 放入到session
     * @param request
     * @param key
     * @param obj
     */
    public static void setSessionObject(HttpServletRequest request,String key,Object obj){
        request.getSession().setAttribute(key, obj);
    }

}

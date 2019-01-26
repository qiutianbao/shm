package com.core.common;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-9-9
 * Time: 上午9:45
 * To change this template use File | Settings | File Templates.
 */
public class StringHelper {
    /**
     * xss 反射式跨站攻击防御
     * @param source
     * @return
     */
    public static String xssEscape(String source){
        return  StringEscapeUtils.escapeHtml(source);
    }

    /**
     * 非空判断
     * @param strIn
     * @return
     */
    public static String null2String(String strIn) {
        return strIn == null ? "" : strIn;
    }

}

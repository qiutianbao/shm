package com.core.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-9-9
 * Time: 上午9:46
 * To change this template use File | Settings | File Templates.
 */
public class UtilDate {
    /** 年月日时分秒(无下划线) yyyyMMddHHmmss */
    public static final String dtLong  = "yyyyMMddHHmmss";

    /** 完整时间 yyyy-MM-dd HH:mm:ss */
    public static final String simple = "yyyy-MM-dd HH:mm:ss";

    /** 年月日(无下划线) yyyyMMdd */
    public static final String dtShort = "yyyyMMdd";

    public static final String dtMedium ="yyyy-MM-dd";

    public static final String dtMediuma ="yyyy/MM/dd";

    /**
     * 返回系统当前时间(精确到毫秒),作为一个唯一的订单编号
     * @return
     *      以yyyyMMddHHmmss为格式的当前系统时间
     */
    public  static String getOrderNum(){
        Date date=new Date();
        DateFormat df=new SimpleDateFormat(dtLong);
        return df.format(date);
    }

    /**
     * 转换日期格式为：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public  static String changeDateFormatter(Date date){
        DateFormat df=new SimpleDateFormat(simple);
        return df.format(date);
    }

}

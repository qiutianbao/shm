package com.core.common;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-9-9
 * Time: 上午10:02
 * To change this template use File | Settings | File Templates.
 */
public class ReadProperties {

    public static  String getDkUrl(String objid,int pIndex,int pSize){
        String dateStr =UtilDate.getOrderNum();
        return String.valueOf(new StringBuffer(Constant.props.get("dkServiceUrl").toString()).append("&app_key=").append(Constant.appKey).append("&timestamp=").append(dateStr).append("&sign=").append(EncryptHelper.encodePassword(Constant.secret + dateStr)).append("&OBJID=").append(objid).append("&PINDEX=").append(pIndex).append("&PSIZE=").append(pSize));
    }

    public static  String getVersion(){
        return String.valueOf(new StringBuffer(Constant.props.get("loginfoversion").toString()).append(" (").append(UtilDate.getOrderNum()).append(")"));
    }

    public static String urlTotal(String url,int pIndex,int pSize){
        return url.replace("&PINDEX="+pIndex,"&PINDEX=1").replace("&PSIZE="+pSize,"&PSIZE="+String.valueOf(Constant.props.get("PSIZE").toString()));
    }

    public static  String getOrder(String col,String or){
        String dkOrder="";
        if("asc".equals(or)){dkOrder="{"+col+":0}";}
        else{dkOrder="{"+col+":1}";}
        return dkOrder;
    }

}

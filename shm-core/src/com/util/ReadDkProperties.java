package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadDkProperties {
    public static String dkUrl;//读取dk配置文件的ip地址
    static {
        Properties prop=new Properties();
        try {
            InputStream in =ReadDkProperties.class.getClassLoader().getResourceAsStream("properties/dk-config.properties");
            prop.load(in);
            dkUrl=prop.getProperty("dkServiceUrl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  String getDkUrl(String objid,int pIndex,int pSize){
        String url = dkUrl+"&objid="+objid+"&PINDEX="+pIndex+"&PSIZE="+pSize;
        return url;
    }

}

package com.util;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-29
 * Time: 下午6:07
 * To change this template use File | Settings | File Templates.
 */
public class WebServiceConfigs {
    private String dkServiceUrl;

    public String getDkServiceUrl(String objid, int pIndex, int pSize) {
        return dkServiceUrl+ "&objid=" + objid + "&PINDEX=" + pIndex + "&PSIZE=" + pSize;
    }

    public void setDkServiceUrl(String dkServiceUrl) {
        this.dkServiceUrl = dkServiceUrl;
    }


}

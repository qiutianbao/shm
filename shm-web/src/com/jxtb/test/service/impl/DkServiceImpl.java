package com.jxtb.test.service.impl;

import com.jxtb.test.service.IDkService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-23
 * Time: 下午2:29
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service("dkService")
public class DkServiceImpl implements IDkService {

    @Value(value = "#{propertiesDkReader['dkServiceUrl']}")
    private String dkUrl;

    @Override
    public String getDkUrl(String objid, int pIndex, int pSize) {
        String url = dkUrl + "&objid=" + objid + "&PINDEX=" + pIndex + "&PSIZE=" + pSize;
        return url;
    }

}

package com.jxtb.test.action;

import com.jxtb.test.entity.JUser;
import com.jxtb.test.service.HXmlService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-4-1
 * Time: 下午5:33
 * To change this template use File | Settings | File Templates.
 */
public class HXmlAction {

    private HXmlService hXmlService;

    public String testAdd(){
        String result;
        try {
            JUser user = new JUser();
            user.setUid("1");
            user.setUsername("波波");
            user.setPassword("1314520");
            user.setAddress("中国");
            int r=hXmlService.addJUserInfo(user);
            if(r>0){
                result="success";
            }else{
                result="error";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="error";
        }

        return result;
    }

    public HXmlService gethXmlService() {
        return hXmlService;
    }

    public void sethXmlService(HXmlService hXmlService) {
        this.hXmlService = hXmlService;
    }
}

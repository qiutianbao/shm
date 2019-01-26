package com.jxtb.test.dao.impl;

import com.core.dao.BaseDao;
import com.jxtb.test.dao.HXmlDao;
import com.jxtb.test.entity.JUser;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-4-1
 * Time: 下午6:03
 * To change this template use File | Settings | File Templates.
 */
public class HXmlDaoImpl  extends BaseDao<JUser> implements HXmlDao{
    @Override
    public int addJUserInfo(JUser user) {
        String sql = "insert into bdqn_user(uid,username,password,address) values(?,?,?,?)";
        int result=getJdbcTemplate().update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getAddress());
        if(result>0){
            return 1;
        }else{
            return 0;
        }
    }
}

package com.jxtb.sys.service.impl;

import com.core.service.impl.BaseServiceImpl;
import com.jxtb.sys.mapper.SysUserMapper;
import com.jxtb.sys.model.SysUser;
import com.jxtb.sys.service.ISysUserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-1-19
 * Time: 下午4:56
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service(value="sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser,SysUserMapper> implements ISysUserService,InitializingBean {
    @Autowired
    private SysUserMapper sysUserMapper;

    public void afterPropertiesSet() throws Exception {
        this.setBaseMapper(sysUserMapper);
    }

}

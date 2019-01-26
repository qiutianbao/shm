package com.jxtb.sys.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-1-20
 * Time: 上午10:24
 * To change this template use File | Settings | File Templates.
 */
public interface CacheMapper {

    public List<Map<String, Object>> listCascadeInfo(Map<String, Object> param) ;

}

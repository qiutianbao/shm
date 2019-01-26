package com.core.service.impl;

import com.core.mapper.BaseMapper;
import com.core.service.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-1-19
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 */
public class BaseServiceImpl <T,I extends BaseMapper<T>> implements IBaseService<T> {

    private I baseMapper;

    public I getBaseMapper() {
        return baseMapper;
    }

    public void setBaseMapper(I baseMapper){
        this.baseMapper = baseMapper;
    }

    public Object insert(T po) {
        return baseMapper.insert(po);
    }

    public int delete(Map<String, Object> param) {
        return baseMapper.delete(param);
    }

    public int update(T po) {
        return baseMapper.update(po);
    }

    public List<T> get(Map<String, Object> param) {
        return baseMapper.get(param);
    }

    /**
     * @return 实体列表
     * @Description:得到所有数据对象列表
     */
    public List <T> getAll() {
        return  baseMapper.getAll();
    }

    public List<T> list(Map<String, Object> param) {
        return baseMapper.list(param);
    }

    public int getCount(Map<String,Object> param) {
        return baseMapper.getCount(param);
    }


}


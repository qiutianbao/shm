package com.core.mapper;


import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
	
	/**
     * @Description:创建数据对象
     * @param po 实体对象
     */
    public abstract Object insert(T po);
    
    /**
     * @Description:删除数据对象
     * @param param map参数
     * @return 所影响的行数
     */
    public abstract int delete(Map<String, Object> param);
    
    /**
     * @Description:单条修改数据对象
     * @param po 实体对象
     * @return 所影响的行数
     */
    public abstract int update(T po);
	
	/**
     * @Description:得到数据对象
     * @param param map参数
     * @return 实体对象
     */
    public abstract List<T> get(Map<String, Object> param);
    
    /**
     * @Description:得到数据对象列表
     * @return 实体列表
     */


    public abstract List <T> getAll();
    /**
     * @Description:得到所有数据对象列表
     * @return 实体列表
     */

    public abstract List<T> list(Map<String, Object> param);
    
    /**
     * @Description:得到数据数量按分页条件
     * @return 数据条数
     */
    public abstract int getCount(Map<String, Object> param);
 
    /**
     * @Description:得到数据对象列表按分页条件 当pp.getNpageSize=0时返回所有
     * @return 实体列表
     */
    public abstract List<T> getSplitList(Map<String, Object> param);

}

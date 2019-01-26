package com.jxtb.test.service;

import com.jxtb.test.entity.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */
public interface ISSTService {

    /**
     * 查询所有问题并按最后修改时间倒序排序
     * @return
     */
   public abstract List<Test> findAllTest();
    /**
     * 保存新问题
     *
     * @return
     */
    public abstract int savTest(Test test);
    /**
     * 查询制定问题的所有答案信息
     *
     * @return
     */
    public abstract Test queryTestById(HashMap<String, Object> map);
    /**
     * 总记录数
     * @return
     */
    public abstract int findTotalCount();
    /**
     * 修改制定问题的回答次数和最后修改时间
     *
     * @return
     */
    public abstract int updateTest(Test test);
    /**
     * 删除问题
     *
     * @return
     */
    public abstract int deleteTest(Test test);


    public List<Map<String, Object>> showAllTest(HashMap<String, Object> map) ;

    public int searchTestTotal(HashMap<String, Object> map);

    public int insertTestInfo(Test test);

    public int deleteTestInfo(Test test);

    public int updateTestInfo(Test test);

}

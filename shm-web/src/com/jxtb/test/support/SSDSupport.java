package com.jxtb.test.support;

import com.jxtb.test.entity.Test;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 下午2:38
 * extends SqlSessionDaoSupport
 */
@SuppressWarnings("ALL")
@Repository("ssdSupport")
public class SSDSupport extends SqlSessionDaoSupport {
    /**
     * 显示所有信息
     * 可转出项目
     * @return
     */

    public List<Map<String, Object>> showAllTest(HashMap<String, Object> map) {
        return getSqlSession().selectList("jxtbTest.getAllTest",map);
    }
    /**
     * 查询总记录数，获取分页总数
     * 可转出项目
     * @return
     */

    public int searchTestTotal(HashMap<String, Object> map) {
        try{
            return (Integer)getSqlSession().selectOne("jxtbTest.getAllCount",map);
        } catch (Exception e) {
            return 0;
        }
    }

    public int insertTestInfo(Test test) {
        return this.getSqlSession().insert("jxtbTest.insert", test);
    }

    public int deleteTestInfo(Test test) {
        int result;
        try{
            this.getSqlSession().delete("jxtbTest.delete", test);
            result=1;
        }catch (Exception e){
            e.printStackTrace();
            result=0;
        }
        return result;
    }

    public int updateTestInfo(Test test) {
        int result;
        try{
            this.getSqlSession().update("jxtbTest.update", test);
            result=1;
        }catch (Exception e){
            e.printStackTrace();
            result=0;
        }
        return result;
    }

}


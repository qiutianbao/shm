package com.jxtb.test.dao.impl;

import com.core.dao.BaseDao;
import com.jxtb.test.dao.HJTemplateDao;
import com.jxtb.test.entity.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-1-20
 * Time: 下午3:00
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Repository("hjTemplateDao")
public class HJTemplateDaoImpl extends BaseDao<Test> implements HJTemplateDao{

    public HJTemplateDaoImpl()
    {
        super.setEntityClass(Test.class);
    }

    public List<Map<String, Object>> selectJdbcTestList(String userId){
        StringBuffer sbSql=new StringBuffer();
        sbSql.append("SELECT id,userName,userPsw FROM cbd_test WHERE id=?");
        return getJdbcTemplate().queryForList(sbSql.toString(), userId);
    }

    @Override
    public int addJdbcTest(Test test) {
        String sql = "insert into cbd_test(id,userName,userPsw) values(?,?,?)";
        int result=getJdbcTemplate().update(sql,test.getId(),test.getUserName(),test.getUserPsw());
        if(result>0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int deleteJdbcTest(Test test) {
        String sql = "delete from cbd_test where id = ?";
        int result=getJdbcTemplate().update(sql, test.getId());
        if(result>0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int updateJdbcTest(Test test) {
        String sql = "update cbd_test set userName =?,userPsw=? where id = ?";
        int result=getJdbcTemplate().update(sql,test.getUserName(),test.getUserPsw(),test.getId());
        if(result>0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public List<Test> findAllTest() {
        String sql = "select * from cbd_test";
        return this.getJdbcTemplate().query(sql, new UserRowMapper());
    }

    @Override
    public String searchUserNameById(String id) {
        String sql = "select userName from cbd_test where id = ?";
        return  this.getJdbcTemplate().queryForObject(sql, String.class, id);
    }

    @Override
    public Test searchJdbcTestById(String id) {
        String sql="select * from cbd_test where id=?";
        return this.getJdbcTemplate().queryForObject(sql, new UserRowMapper(), id);
    }

    class UserRowMapper implements RowMapper<Test> {
        //rs为返回结果集，以每行为单位封装着
        @Override
        public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
            Test user = new Test();
            user.setId(rs.getString("id"));
            user.setUserName(rs.getString("userName"));
            user.setUserPsw(rs.getString("userPsw"));
            return user;
        }
    }

    public List<Test> selectHibernateTestList(){
        List<Test> test = (List<Test>) getHibernateTemplate().find("from Test");
        return test;
    }

    @Override
    public int addHibernateTest(Test test) {
        int result=0;
        try{
            getHibernateTemplate().save(test);
            result= 1;
        }catch (Exception e){
            e.printStackTrace();
            result= 0;
        }
        return  result;
    }

    @Override
    public int updateHibernateTest(Test test) {
        int result=0;
        try{
            getHibernateTemplate().update(test);
            result= 1;
        }catch (Exception e){
            result= 0;
        }
        return  result;
    }

    @Override
    public int deleteHibernateTestById(Test test) {
        int result=0;
        try {
            super.getHibernateTemplate().delete(test);
            result=1;
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return result;
    }

    @Override
    public Test searchHibernateTestById(String id) {
        return super.getHibernateTemplate().get(Test.class, id);
    }

}

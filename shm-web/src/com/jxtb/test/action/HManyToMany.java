package com.jxtb.test.action;

import com.jxtb.test.entity.ManageRole;
import com.jxtb.test.entity.ManageUser;
import com.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-31
 * Time: 上午11:25
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
public class HManyToMany {
    //演示多对多修级联保存
    public void testSave() {
        SessionFactory sessionFactory=HibernateUtils.getSessionFactory();
        Session session=null;
        Transaction transaction = null;
        try {
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();

            //添加两个用户，为每个用户添加两个角色
            //1 创建对象
            ManageUser user1 = new ManageUser();
            user1.setUser_name("lucy");
            user1.setUser_password("123");

            ManageUser user2 = new ManageUser();
            user2.setUser_name("mary");
            user2.setUser_password("456");

            ManageRole r1 = new ManageRole();
            r1.setRole_name("总经理");
            r1.setRole_memo("总经理");

            ManageRole r2 = new ManageRole();
            r2.setRole_name("秘书");
            r2.setRole_memo("秘书");

            ManageRole r3 = new ManageRole();
            r3.setRole_name("保安");
            r3.setRole_memo("保安");

            //2 建立关系，把角色放到用户里面
            // user1 -- r1/r2
            user1.getSetRole().add(r1);
            user1.getSetRole().add(r2);

            // user2 -- r2/r3
            user2.getSetRole().add(r2);
            user2.getSetRole().add(r3);

            //3 保存用户
            session.save(user1);
            session.save(user2);

            //提交事务
            transaction.commit();

        }catch(Exception e) {
            transaction.rollback();
        }finally {
            session.close();
            //sessionFactory不需要关闭
            sessionFactory.close();
        }
    }

    //演示维护第三张表
    public void testAddTable1() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            //得到sessionFactory
            sessionFactory = HibernateUtils.getSessionFactory();
            //得到session
            session = sessionFactory.openSession();
            //开启事务
            tx = session.beginTransaction();

            // 让某个用户有某个角色
            //让lucy有经纪人角色
            //1 查询lucy和经纪人
            ManageUser lucy = (ManageUser) session.get(ManageUser.class, "1");
            ManageRole role = (ManageRole) session.get(ManageRole.class, "1");

            //2 把角色放到用户的set集合里面
            lucy.getSetRole().add(role);

            //提交事务
            tx.commit();

        }catch(Exception e) {
            tx.rollback();
        }finally {
            session.close();
            //sessionFactory不需要关闭
            sessionFactory.close();
        }
    }


    //演示维护第三张表
    public void testDeleteTable1() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            //得到sessionFactory
            sessionFactory = HibernateUtils.getSessionFactory();
            //得到session
            session = sessionFactory.openSession();
            //开启事务
            tx = session.beginTransaction();

            // 让某个用户有某个角色
            //让lucy有经纪人角色
            //1 查询lucy和经纪人
            ManageUser lucy = (ManageUser) session.get(ManageUser.class, "1");
            ManageRole role = (ManageRole) session.get(ManageRole.class, "2");

            //2 从用户里面把角色去掉
            lucy.getSetRole().remove(role);

            //提交事务
            tx.commit();

        }catch(Exception e) {
            tx.rollback();
        }finally {
            session.close();
            //sessionFactory不需要关闭
            sessionFactory.close();
        }
    }

}


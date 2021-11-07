package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import com.itheima.domain.User1;
import com.itheima.domain.User2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.InputStream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.dao
 * Description:
 * 测试mybatis的CRUD操作
 *
 * @Date:2021/7/17 11:22
 * @Author:zhang'lin zhanglin@163.com
 */
public class MybatisTest {


    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;


    @Before
    public void init() throws Exception {
        //读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //读取sqlsessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取sqlsession
        session = factory.openSession(true);
        //获取到代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception {
        //关闭链接之前进行事务的提交工作
//        session.commit();
        session.close();
        in.close();
    }

    /**
     * 测试查询所有数据
     *
     * @return
     */
    @Test
    public void testFindAll() {

        //执行sql语句
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试根据id查询用户
     */
    @Test
    public void testFandById() {
        User user = userDao.findById(21);
        System.err.println(user);
    }


    /**
     * 测试按名字模糊查询
     */
    @Test
    public void testFandByName() {
//        List<User> users = userDao.fandByName("王");
      List<User> users = userDao.fandByName("%王%");
        for (User user : users) {
            System.err.println(user);
        }
    }

    /**
     * 根据Vo的查询条件，进行模糊查询
     */
    @Test
    public void testFandByVo(){

        User user = new User();
        user.setUsername("%san%");
        QueryVo vo =new QueryVo();
        vo.setUser(user);
        System.err.println("vo查询："+userDao.fandByVo(vo));

    }

    /**
     * 测试根据传入参数，来查询
     *
     */
    @Test
    public void testFandByContition(){
        User user =new User();
        user.setUsername("老王");
        user.setSex("男");
        List<User> users =userDao.fandByContition(user);
        for (User u:users){
            System.err.println(u);
        }
    }

    /**
     * 测试foreach标签的in的子查询
     *
     */
    @Test
    public void testFandByIds(){

        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(21);
        ids.add(23);
        vo.setIds(ids);
        List<User> users = userDao.fandByIds(vo);
        for(User user:users){
            System.err.println("User:" +user);
        }

    }


}


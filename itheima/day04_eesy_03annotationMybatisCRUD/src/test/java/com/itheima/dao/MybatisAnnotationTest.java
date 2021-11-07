package com.itheima.dao;

import com.itheima.domain.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.InputStream;

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
public class MybatisAnnotationTest {
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
        session = factory.openSession();
        //获取到代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception {
        //关闭链接之前进行事务的提交工作
        session.commit();
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
     * 测试保存数据
     *
     * @throws Exception
     */
    @Test
    public void testSave() throws Exception {
        User user = new User();
//        user.setId(1);
        user.setUsername("annotation测试");
        user.setAddress("福建省福州市");
        user.setSex("女");
        user.setBirthday(new Date());
//        System.out.println("user :"+ user);
        userDao.save(user);
    }

    /**
     * 测试更新数据
     */
    @Test
    public void testUpdate() {

        User user = new User();
        user.setId(61);
        user.setBirthday(new Date());
        user.setUsername("annotation测试update");
        user.setSex("女");
        user.setAddress("update 福州");
        userDao.updateUser(user);
    }

    /**
     * 测试根据删除用户
     */
    @Test
    public void testDelete() {
        userDao.deleteUser(60);

    }

    /**
     * 测试按名字模糊查询
     */
    @Test
    public void testFandByName() {
//        List<User> users = userDao.fandByName("王");
      List<User> users = userDao.fandByName("%annotation%");
        for (User user : users) {
            System.err.println(user);
        }
    }

    /**
     * 测试查询用户的总数
     */
    @Test
    public void testFandCount(){

        System.err.println("用户总数："+userDao.findCount());

    }






}

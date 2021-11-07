package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.domain.User1;
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
 * 测试mybatis的注解，实现实体类属性和表的列名不一致的测试
 *
 * @Date:2021/7/17 11:22
 * @Author:zhang'lin zhanglin@163.com
 */
public class MybatisAnnotationUser1Test {
    private InputStream in;
    private SqlSession session;
    private IUser1Dao user1Dao;


    @Before
    public void init() throws Exception {
        //读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //读取sqlsessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取sqlsession
        session = factory.openSession();
        //获取到代理对象
        user1Dao = session.getMapper(IUser1Dao.class);
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
        List<User1> user1s = user1Dao.findAll();
        for (User1 user1 : user1s) {
            System.out.println(user1);
        }
    }

    /**
     * 测试根据id查询用户
     */
    @Test
    public void testFandById() {
        User1 user1 = user1Dao.findById(21);
        System.err.println(user1);
    }


    /**
     * 测试按名字模糊查询
     */
    @Test
    public void testFandByName() {
//        List<User> users = userDao.fandByName("王");
      List<User1> user1s = user1Dao.fandByName("%annotation%");
        for (User1 user1 : user1s) {
            System.err.println(user1);
        }
    }

    /**
     * 测试查询用户的总数
     */
    @Test
    public void testFandCount(){

        System.err.println("用户总数："+user1Dao.findCount());

    }






}
